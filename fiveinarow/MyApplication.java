package com.lifeng.java.fiveinarow;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * 五子棋项目
 *      -----单机版
 * @author lifeng
 * @create 2022-06-30 11:32
 */
public class MyApplication extends Application {

    //把一些字面量抽取出来
    private double margin = 30.0;//外边距
    private double size = 30.0;//每个格子的大小
    private double allSize = 600;//五子棋大小600*600
    private boolean isBlack = true;//定义一个标记，若为true,则执黑子，否则执白子
    private Pane pane = null;//定义画板对象
    Chess[] chesses = new Chess[19*19];//创建一个棋子对象用来存储已经落子的坐标
    private Stage stage = null;//定义舞台的引用
    private int Count = 0;//棋子个数
    private int isFive = 1;//计数器，判断是否满足条件的棋子是否大于等于五个
    private boolean isWin = false;//判断是否胜利，true代表胜利
    private int listSize = 0;//打谱中,存储list集合的长度
    public static void main(String[] args) {
        //启动
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //创建画板对象
        pane = new Pane();

        //将参数中的局部变量赋给成员变量
        this.stage = primaryStage;

        //为画板设置颜色
        pane.setBackground(new Background(new BackgroundFill(Color.PINK,null,null)));

        moveInChess(pane);

        //创建场景对象,并且将画板放到场景上
        Scene scene = new Scene(pane,600,650);

        //将场景设置到舞台上
        primaryStage.setScene(scene);

        //给舞台对象设置点击X事件
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {

                //创建弹框对象
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("退出");
                alert.setHeaderText("你确定要退出吗");
                //展示
                Optional<ButtonType> optional = alert.showAndWait();
                if (optional.get() == ButtonType.OK){
                }else {
                    event.consume();//执行此方法取消退出
                }
            }
        });

        //展示舞台
        primaryStage.show();

    }

    /**
     * 落子
     * @param pane
     */
    private void moveInChess(Pane pane) {
        //给画板绑定鼠标单击事件
        pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                //判断如果胜利就不再继续执行下面的代码
                if (isWin){
                    return;
                }

                //获取鼠标点击位置的横纵坐标
                double x = event.getX();
                double y = event.getY();

//                System.out.println(x + "..." + y);

                //判断如果点击的坐标均在外边距内，那么就不落子，直接return
                if (!(x > margin && x < (allSize - margin) && y > margin && y < (allSize - margin))){
                    return;
                }

//                System.out.println(x + "..." + y);
                //占横纵格子的数
                int _x = (int)((x + margin + size/2)/size)-2;
                int _y = (int)((y + margin + size/2)/size)-2;
//                System.out.println(_x + "..." + _y);

                //判断该点是否已有棋子
                if (ifLive(_x,_y)){
                    return;
                }

                //创建第一个圆
                Circle circle = null;
                //创建棋子对象
                Chess chess = null;

                if (Count % 2 == 0){
                    isBlack = true;
                }

                if (isBlack){
                    //设置为黑色
                    circle = new Circle((_x * size)+margin,(_y * size)+margin ,10,Color.BLACK);
                    isBlack = false;
                    chess = new Chess(_x,_y,Color.BLACK);
                }else {
                    //设置为白色
                    circle = new Circle((_x * size)+margin,(_y * size)+margin ,10,Color.WHITE);
                    isBlack = true;
                    chess = new Chess(_x,_y,Color.WHITE);
                }

                //将圆放到画板上
                pane.getChildren().add(circle);
                //将棋子坐标保存到Chess对象中
                chesses[Count] = chess;
                Count++;

                //判断是否胜利？
                if(isWin(chess)){
                    isWin = true;
                    pop_up();
                    return;
                }
            }
        });

        int y = 30;//棋盘的y坐标
        int x = 30;//棋盘的x坐标
        for (int i= 0;i <= 18;i++){

            if (y <=600){
                //创建线条对象
                Line line1 = new Line(30,y,570,y);
                y +=30;
                //将线条对象放到画板上
                pane.getChildren().add(line1);
            }

            if (x <= 600){
                //创建线条对象
                Line line2 = new Line(x,30,x,570);
                x += 30;
                //将线条对象放到画板上
                pane.getChildren().add(line2);
            }

            //获取开始按钮对象
            Button startButton = getStartButton();
            //获取结束按钮
            Button quitButton = getQuitButton();
            //获取悔棋按钮
            Button retractButton = getRetractButton();
            //获取保存棋谱按钮
            Button saveButton = getSaveButton();
            //获取打谱按钮
            Button hitButton = getHitButton();

            //将开始按钮放到画板上
            pane.getChildren().add(startButton);
            //将结束按钮放到画板上
            pane.getChildren().add(quitButton);
            //将悔棋按钮放在画板上
            pane.getChildren().add(retractButton);
            //将保存棋谱按钮放到画板上
            pane.getChildren().add(saveButton);
            //将打谱按钮放到画板上
            pane.getChildren().add(hitButton);

        }
    }

    /**
     * 打谱按钮
     * @return
     */
    private Button getHitButton() {
        Button button = new Button("打谱");
        button.setPrefSize(80,30);
        //设置x和y坐标
        button.setLayoutX(65);
        button.setLayoutY(600);

        button.setOnAction(new EventHandler<ActionEvent>() {

            LinkedList<Chess> list = null;//存储Chess对象

            @Override
            public void handle(ActionEvent event) {

                //创建打开框对象
                FileChooser fileChooser = new FileChooser();
                //展示
                File file = fileChooser.showOpenDialog(stage);//打开框全路径

                if (file == null){
                    return;
                }
                System.out.println("文件路径为："+file);
                //1.创建输入流对象,读取棋谱文件中的内容，把内容装到list集合中
                BufferedReader br = null;

                try {
                    br = new BufferedReader(new FileReader(file));
                    list = new LinkedList<>();//创建list的对象
                    String s = null;
                    while ((s = br.readLine()) != null){
                        //得到每一行棋子对象信息
                        String[] split = s.split(",");

                        System.out.println(split[0] + "..." + split[1] + "..." + split[2]);

                        if ("0x000000ff".equals(split[2])){//若以0ff结尾则为黑色
                            //存储棋子信息
                            list.add(new Chess(Integer.parseInt(split[0]),Integer.parseInt(split[1]),Color.BLACK));
                        }else{
                            //存储棋子信息
                            list.add(new Chess(Integer.parseInt(split[0]),Integer.parseInt(split[1]),Color.WHITE));
                        }
                    }
                } catch (Exception e) {
                    System.out.println("打谱失败");
                }finally {
                    if (br != null){
                        try {
                            br.close();//关流
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                System.out.println("已拿到所有棋子对象");
                listSize = list.size() - 1;//将集合长度-1赋给listSize

                //2.得到了list集合，先创建三个按钮
                //2.1  下一步按钮
                Button nextButton = getNextButton();

                //2.2  上一步按钮
                Button lastButton = getLastButton();

                //2.3  退出按钮
                Button exitButton = getExitButton();

                //最后将按钮放到棋盘上
                pane.getChildren().add(nextButton);
                pane.getChildren().add(lastButton);
                pane.getChildren().add(exitButton);

            }



            /**
             * 打谱中的下一步按钮
             * @return
             */
            private Button getNextButton() {

                Button nextButton = new Button(">");

                //设置x和y坐标
                nextButton.setLayoutX(570);
                nextButton.setLayoutY(250);

                nextButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                        if (listSize < 0){
                            isBlack = true;
                            return;
                        }

                        Chess chess = list.get(listSize);//获取集合中最后一个元素

                        if (listSize % 2 != 0){
                            isBlack = false;
                        }

                        if (isBlack){
                            Circle circle = new Circle((chess.getX() * size) + margin,(chess.getY() * size) + margin,10,Color.BLACK);
                            pane.getChildren().add(circle);
                            //将棋子坐标保存到Chess对象中
                            chesses[Count] = chess;
                            Count++;
                            isBlack = false;
                        }else {
                            Circle circle = new Circle((chess.getX() * size) + margin,(chess.getY() * size) + margin,10,Color.WHITE);
                            pane.getChildren().add(circle);
                            //将棋子坐标保存到Chess对象中
                            chesses[Count] = chess;
                            Count++;
                            isBlack = true;
                        }

                        listSize--;

                    }
                });

                return nextButton;

            }

            /**
             * 打谱中上一步按钮
             * @return
             */
            private Button getLastButton() {
                Button lastButton = new Button("<");
                //设置x和y坐标
                lastButton.setLayoutX(570);
                lastButton.setLayoutY(300);

                lastButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        ObservableList<Node> children = pane.getChildren();
                        children.remove(children.size() - 1);//删除children集合中的最后一个元素，就是上一步棋子对象
                        Count--;//棋子个数减一
                        isBlack = !isBlack;//将棋子颜色换到上一步
                        listSize++;//点击一次回退,那么集合的长度加一
                    }
                });

                return lastButton;
            }

            /**
             * 打谱中退出按钮
             * @return
             */
            private Button getExitButton() {
                Button exitButton = new Button("x");
                //设置x和y坐标
                exitButton.setLayoutX(570);
                exitButton.setLayoutY(350);

                exitButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        //创建弹框对象
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("退出");
                        alert.setHeaderText("你确定要退出打谱吗?");
                        //展示弹框
                        Optional<ButtonType> optional = alert.showAndWait();
                        if (optional.get() == ButtonType.OK){
                            // TODO 退出功能

                        }else {
                            event.consume();//执行此方法取消退出
                        }
                    }
                });

                return exitButton;
            }

        });

        return button;

    }


    /**
     * 保存棋谱
     * @return
     */
    private Button getSaveButton() {
        Button button = new Button("保存棋谱");
        button.setPrefSize(80,30);
        //设置x和y坐标
        button.setLayoutX(165);
        button.setLayoutY(600);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //保存棋谱代码
                if (!isWin){
                    return;
                }
                //创建保存框对象
                FileChooser fileChooser = new FileChooser();
                //展示
                File file = fileChooser.showSaveDialog(stage);//当前file为保存文件的绝对路径
                //创建输出流对象，将棋子对象存入文件中
                if (file != null){
                    BufferedWriter bw = null;
                    try {
                        bw = new BufferedWriter(new FileWriter(file));

                        for (int i = 0; i < Count; i++) {
                            bw.write(chesses[i].getX() + "," + chesses[i].getY() + "," + chesses[i].getColor());
                            bw.newLine();//换行
                            bw.flush();//刷新缓冲区
                        }

                    } catch (IOException e) {
                        System.out.println("保存棋谱失败");
                    }finally {
                        if (bw != null){
                            try {
                                bw.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
        return button;
    }


    /**
     * 悔棋
     * @return
     */
    private Button getRetractButton(){
        Button button = new Button("悔棋");
        button.setPrefSize(80,30);
        //设置x和y坐标
        button.setLayoutX(265);
        button.setLayoutY(600);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("悔棋");
                alert.setHeaderText("你确定要悔棋吗?");

                //展示
                Optional<ButtonType> optional = alert.showAndWait();
                if (optional.get() == ButtonType.OK){
                    //确定悔棋
                    if (Count > 0){
                        ObservableList<Node> children = pane.getChildren();
                        children.remove(children.size() - 1);//删除children集合中的最后一个元素，就是上一步棋子对象
                        Count--;//棋子个数减一
                        isBlack = !isBlack;//将棋子颜色换到上一步
                    }
                }else {
                    event.consume();//取消弹框
                }
            }
        });

        return button;
    }

    /**
     * 退出按钮
     * @return
     */
    private Button getQuitButton(){

        Button button = new Button("退出");

        button.setPrefSize(80,30);
        //设置x和y坐标
        button.setLayoutX(365);
        button.setLayoutY(600);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //创建弹框对象
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("退出");
                alert.setHeaderText("你确定要退出吗?");
                //展示弹框
                Optional<ButtonType> optional = alert.showAndWait();
                if (optional.get() == ButtonType.OK){
                    Platform.exit();
                }else {
                    event.consume();//执行此方法取消退出
                }
            }
        });

        return button;
    }

    /**
     * 获取再来一局按钮对象
     * @return
     */
    private Button getStartButton() {
        //添加按钮对象
        Button button = new Button("再来一局");
        //设置按钮对象
        button.setPrefSize(80,30);
        //设置x和y坐标
        button.setLayoutX(465);
        button.setLayoutY(600);

        //给点击按钮绑定鼠标单击事件
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //再来一局代码实现
                System.out.println("再来一局");
                //判断如果胜利的话才能执行清空
                if (!isWin){
                    return;
                }

                //清空画板上的圆圈Circle对象
                pane.getChildren().removeIf(new Predicate<Object>() {
                    @Override
                    public boolean test(Object o) {
                        return o instanceof Circle;
                    }
                });

                //将棋子对象清空
                chesses = new Chess[19*19];

                //计数器Count重新归零
                Count = 0;

                //将胜负标记置为false
                isWin = false;

                //将棋子颜色重新置为黑色
                isBlack = true;

            }
        });

        return button;
    }

    /**
     *   判断是否获胜
     */
    private boolean isWin(Chess chess) {
        //先获取当前落子的横纵坐标
        int x = chess.getX();
        int y = chess.getY();
        Color color = chess.getColor();

        //水平方向------------------------------------------------------------
        //1.向右
        for (int i = x+1;i <= x+4 && i < 19;i++){
            //获取右边棋子对象
            Chess _chess = getChess(i,y);
            if (_chess != null && _chess.getColor().equals(chess.getColor())){
                isFive++;
            }else {
                break;
            }
        }

        //2.向左
        for (int i = x-1;i >= x-4 && i >= 0;i--){
            //获取右边棋子对象
            Chess _chess = getChess(i,y);
            if (_chess != null && _chess.getColor().equals(chess.getColor())){
                isFive++;
            }else {
                break;
            }
        }

        if (isFive>=5){
            isFive = 1;
            return true;
        }

        isFive = 1;

        //垂直方向------------------------------------------------------------------
        //1.向上
        for (int i = y+1;i <= y+4 && i < 19;i++){
            //获取上边棋子对象
            Chess _chess1 = getChess(x,i);
            if (_chess1 != null && _chess1.getColor().equals(chess.getColor())){
                isFive++;
            }else {
                break;
            }
        }

        //2.向下
        for (int i = y-1;i >= y-4 && i >= 0;i--){
            //获取下边棋子对象
            Chess _chess1 = getChess(x,i);
            if (_chess1 != null && _chess1.getColor().equals(chess.getColor())){
                isFive++;
            }else {
                break;
            }
        }

        //判断胜负
        if (isFive>=5){
            isFive = 1;
            return true;
        }

        isFive = 1;

        //右斜向上方向----------------------------------------------------------
        //1.向右上
        for (int i = x+1,j = y - 1;i <= x+4 && i < 19&&j >= y-4 && j >= 0;i++,j--){

            //获取右边棋子对象
            Chess _chess = getChess(i,j);
            if (_chess != null && _chess.getColor().equals(chess.getColor())){
                isFive++;
            }else {
                break;
            }
        }

        //2.向左下
        for (int i = x-1,j = y+1;i >= x-4 && i >= 0 && j <= y +4 && j < 19;i--,j++){
            //获取右边棋子对象
            Chess _chess = getChess(i,j);
            if (_chess != null && _chess.getColor().equals(chess.getColor())){
                isFive++;
            }else {
                break;
            }
        }

        //判断胜负
        if (isFive>=5){
            isFive = 1;
            return true;
        }

        isFive = 1;

        //左斜向下方向--------------------------------------------------------------
        //1.左向上
        for (int i = x - 1,j = y - 1;i >= x-4 && i >= 0 && j <= y +4 && j < 19;i--,j--){
            //获取右边棋子对象
            Chess _chess = getChess(i,j);
            if (_chess != null && _chess.getColor().equals(chess.getColor())){
                isFive++;
            }else {
                break;
            }
        }

        //2.向左向下
        for (int i = x+1,j = y+1;i <= x+4 && i < 19 && j >= y -4 && j > 0;i++,j++){
            //获取右边棋子对象
            Chess _chess = getChess(i,j);
            if (_chess != null && _chess.getColor().equals(chess.getColor())){
                isFive++;
            }else {
                break;
            }
        }

        //判断胜负
        if (isFive>=5){
            isFive = 1;
            return true;
        }

        isFive = 1;
        return false;

    }

    /**
     * 获取棋子对象
     * @param x x
     * @param y y
     * @return
     */
    private Chess getChess(int x, int y) {
        for (int i = 0;i < Count; i++){
            Chess chess = chesses[i];
            if (chess.getX() == x && chess.getY() == y){
                return chess;
            }
        }
        return null;
    }

    /**
     * 判断某坐标是否已有棋子
     * @param x 横坐标
     * @param y 纵坐标
     * @return 返回值
     */
    private boolean ifLive(int x, int y) {
        for (int i = 0;i < Count; i++){
            Chess chess = chesses[i];
            if (chess.getX() == x && chess.getY() == y){
                return true;
            }
        }
        return false;
    }

    /**
     * 获胜弹框
     */
    public static void pop_up(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("获胜");
        alert.setHeaderText("恭喜您胜利了！");
        alert.setContentText("撒花");
        alert.showAndWait();//展示弹出框
    }


}
