package com.lifeng.java.gobang.ui.web;

import com.lifeng.java.gobang.Global;
import com.lifeng.java.gobang.message.ChessMessage;
import com.lifeng.java.gobang.message.ClearMessage;
import com.lifeng.java.gobang.message.Message;
import com.lifeng.java.gobang.message.RetractMessage;
import com.lifeng.java.gobang.pojo.Chess;
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
import javafx.stage.WindowEvent;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * 五子棋项目
 *      -----单机版
 * @author lifeng
 * @create 2022-06-30 11:32
 *      (Stage就是舞台)
 */
public class WebUI extends Stage {

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
    private boolean canPlay = true;//是否可以落子的判定。true代表可以落子，false代表不可用落子
    public Button button = null;//悔棋按钮
    public Button startbutton = null;//再来一局按钮


    public WebUI() {

        //创建画板对象
        pane = new Pane();

        //将参数中的局部变量赋给成员变量
        this.stage = this;

        //为画板设置颜色
        pane.setBackground(new Background(new BackgroundFill(Color.PINK,null,null)));

        moveInChess(pane);

        //创建场景对象,并且将画板放到场景上
        Scene scene = new Scene(pane,600,650);

        //将场景设置到舞台上
        stage.setTitle("五子棋网络版");
        stage.setResizable(true);
        stage.setScene(scene);

        //给舞台对象设置点击X事件
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
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
//        stage.show();

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
                if (isWin || !canPlay){
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

                //落完子之后,就将canPlay更改为false
                canPlay = false;



                //发送端(落完子之后,将棋子信息传给对面的接收端)-----------------------------

                Socket socket = null;
                try {
                    //1.创建Socket对象(传入对方的IP和端口号)
                    socket = new Socket(Global.oipText,Global.oportText);
                    //2.创建要发送的数据
                    //3.创建管道输出流对象
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    //4.写出(发送)数据
                    oos.writeObject(new ChessMessage(_x,_y,!isBlack));

                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    //非空校验
                    //关闭资源
                    if (socket != null){
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                //判断是否胜利？
                if (isWin(chess) && canPlay){//若对方胜利
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("失败");
                    alert.setHeaderText("很遗憾您输了！");
                    alert.setContentText("继续努力");
                    alert.initOwner(WebUI.this);
                    alert.showAndWait();//展示弹出框
                    return;
                }

                if(isWin(chess)){
                    isWin = true;
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("获胜");
                    alert.setHeaderText("恭喜您胜利了！");
                    alert.setContentText("撒花");
                    alert.initOwner(WebUI.this);
                    alert.showAndWait();//展示弹出框
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


            //添加按钮对象
            startbutton= new Button("再来一局");
            //设置按钮对象
            startbutton.setPrefSize(80,30);
            //设置x和y坐标
            startbutton.setLayoutX(465);
            startbutton.setLayoutY(600);
            //给点击按钮绑定鼠标单击事件

            //再来一局------------------------------------
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    startbutton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            //再来一局代码实现
                            //判断如果胜利的话才能执行清空
                            if (!isWin){
                                return;
                            }

                            //发送端发送清空棋盘信息
                            Socket socket = null;
                            try {
                                //1.创建Socket对象(传入对方的IP和端口号)
                                socket = new Socket(Global.oipText,Global.oportText);
                                //2.创建要发送的数据
                                //3.创建管道输出流对象
                                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                                //4.写出(发送)数据
                                ClearMessage clearMessage = new ClearMessage();
                                clearMessage.setFlag(ClearMessage.IS_CLEAR);//1代表发送端的清空棋盘信息
                                oos.writeObject(clearMessage); //将清空棋盘信息发送给对面
                                //创建弹框对象
                                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                                alert1.setTitle("清空棋盘");
                                alert1.setHeaderText("已将清空棋盘信息发送给了对方！");
                                //展示
                                alert1.showAndWait();
                                Thread.sleep(100);
                                alert1.close();
                                //接受反馈信息
                                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                                //读取
                                Object obj = ois.readObject();
                                ClearMessage clearMessage1 = (ClearMessage) obj;
                                if (clearMessage1.getFlag() == ClearMessage.ALLOW_CLEAR){//flag等于2代表对面同意清空棋盘
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

                                }else {
                                    return;
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }finally {
                                //非空校验
                                //关闭资源
                                if (socket != null){
                                    try {
                                        socket.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }

                        }
                    });
                }
            });

            //获取结束按钮
            Button quitButton = getQuitButton();
            //获取悔棋按钮
            button = new Button("悔棋");
            button.setPrefSize(80,30);
            //设置x和y坐标
            button.setLayoutX(265);
            button.setLayoutY(600);
            //悔棋------------------------------------------
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("悔棋");
                            alert.setHeaderText("你确定要悔棋吗?");
                            alert.initOwner(WebUI.this);
                            //展示
                            Optional<ButtonType> optional = alert.showAndWait();
                            if (optional.get() == ButtonType.OK){
                                //确定悔棋
                                if (Count > 0){
                                    //发送端发送悔棋信息
                                    Socket socket = null;
                                    try {
                                        //1.创建Socket对象(传入对方的IP和端口号)
                                        socket = new Socket(Global.oipText,Global.oportText);
                                        //2.创建要发送的数据
                                        //3.创建管道输出流对象
                                        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                                        //4.写出(发送)数据
                                        RetractMessage retractMessage = new RetractMessage();
                                        retractMessage.steFlag(1);//1代表发送端的悔棋信息
                                        oos.writeObject(retractMessage);//将悔棋信息发送给对面
                                        //弹出一个弹框，
                                        //创建弹框对象
                                        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                                        alert1.setTitle("悔棋");
                                        alert1.setHeaderText("对方毫不犹豫且肯定的同意了您的悔棋！");
                                        //展示
                                        alert1.showAndWait();

                                        //接受反馈信息
                                        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                                        //读取
                                        Object obj = ois.readObject();
                                        RetractMessage retractMessage1 = (RetractMessage) obj;
                                        if (retractMessage1.getFlag() == 2){//flag等于2代表对面同意悔棋
                                            ObservableList<Node> children = pane.getChildren();
                                            children.remove(children.size() - 1);//删除children集合中的最后一个元素，就是上一步棋子对象
                                            Count--;//棋子个数减一
                                            isBlack = !isBlack;//将棋子颜色换到上一步
                                            System.out.println("------------------------------------");
                                        }else {
                                            //创建弹框对象
                                            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                                            alert2.setTitle("悔棋");
                                            alert2.setHeaderText("对方不同意悔棋！");
                                            //展示
                                            alert2.showAndWait();
                                        }

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }finally {
                                        //非空校验
                                        //关闭资源
                                        if (socket != null){
                                            try {
                                                socket.close();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
//                                    System.out.println("内部button的值："+button);
                                }
                            }else {
                                event.consume();//取消弹框
                            }

                        }

                    });
                }
            });

            //将开始按钮放到画板上
            pane.getChildren().add(startbutton);
            //将结束按钮放到画板上
            pane.getChildren().add(quitButton);
            //将悔棋按钮放在画板上
            pane.getChildren().add(button);

        }
    }


    /**
     * 悔棋
     * @return
     */
//    private Button getRetractButton() {

//        return button;
//    }


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
                alert.setTitle("退0出");
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
     * 更改棋盘的方法
     * @param chessMessage
     */
    public void update(ChessMessage chessMessage) {
        //对方落完子会调用update,name就将canPlay更改为true,表示这边可以落子
        canPlay = true;
        //Platform.runLater(new Runnable() :解决JavaFX多线程报错问题
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                //占横纵格子的数
                int _x = chessMessage.getX();
                int _y = chessMessage.getY();

                //创建第一个圆
                Circle circle = null;
                //创建棋子对象
                Chess chess = null;

                if (Count % 2 == 0){
                    isBlack = true;
                }

                if (chessMessage.isBlack()){
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
                if (isWin(chess) && canPlay){//若对方胜利
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("失败");
                    alert.setHeaderText("很遗憾您输了！");
                    alert.setContentText("继续努力");
                    alert.initOwner(WebUI.this);
                    alert.showAndWait();//展示弹出框
                    return;
                }
                if(isWin(chess)){
                    isWin = true;
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("获胜");
                    alert.setHeaderText("恭喜您胜利了！");
                    alert.setContentText("撒花");
                    alert.initOwner(WebUI.this);
                    alert.showAndWait();//展示弹出框
                    return;
                }
            }
        });
    }

    /**
     * 接收端悔棋
     */
    public void RetractChess() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                ObservableList<Node> children = pane.getChildren();
                children.remove(children.size() - 1);//删除children集合中的最后一个元素，就是上一步棋子对象
                Count--;//棋子个数减一
                isBlack = !isBlack;//将棋子颜色换到上一步
            }
        });
    }

    /**
     * 接收端清空棋盘
     */
    public void ClearChess() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
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
    }
}
