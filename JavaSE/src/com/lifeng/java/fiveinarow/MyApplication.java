package com.lifeng.java.fiveinarow;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * 五子棋项目
 *
 * @author lifeng
 * @create 2022-06-30 11:32
 */
public class MyApplication extends Application {

    //把一些字面量抽取出来
    private double margin = 30.0;//外边距
    private double size = 30.0;//每个格子的大小
    private double allSize = 600;
    private boolean flag = true;//定义一个标记，若为true,则执黑子，否则执白子

    int num = (int)(allSize/size)-1;//获取落子的数量

    Chess[] chesses = new Chess[19*19];//创建一个棋子对象用来存储已经落子的坐标

    private int Count = 0;//棋子个数

    private int isFive = 1;//计数器，判断是否满足条件的棋子是否大于等于五个

    public static void main(String[] args) {
        //启动
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //创建画板对象
        Pane pane = new Pane();

        //为画板设置颜色
        pane.setBackground(new Background(new BackgroundFill(Color.PINK,null,null)));

        //给画板绑定鼠标单击事件
        pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
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

                //切换标记
//                System.out.println(flag);

                if (flag){
                    //设置为黑色
                    circle = new Circle((_x * size)+margin,(_y * size)+margin ,10,Color.BLACK);
                    flag = false;
                    chess = new Chess(_x,_y,Color.BLACK);
                }else {

                    //设置为白色
                    circle = new Circle((_x * size)+margin,(_y * size)+margin ,10,Color.WHITE);
                    flag = true;
                    chess = new Chess(_x,_y,Color.WHITE);
                }

                //将圆放到画板上
                pane.getChildren().add(circle);
                //将棋子坐标保存到Chess对象中
                chesses[Count] = chess;
                Count++;

                //判断是否胜利？
                if(isWin1(chess)){
                    System.out.println("您赢了");
                }

                //判断是否胜利？
                if(isWin2(chess)){
                    System.out.println("您赢了");
                }

                //判断是否胜利？
                if(isWin3(chess)){
                    System.out.println("您赢了");
                }

                //判断是否胜利？
                if(isWin4(chess)){
                    System.out.println("您赢了");
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
        }

        //创建场景对象,并且将画板放到场景上
        Scene scene = new Scene(pane,600,600);

        //将场景设置到舞台上
        primaryStage.setScene(scene);

        //展示舞台
        primaryStage.show();

    }

    //判断是否获胜
    private boolean isWin1(Chess chess) {
        //先获取当前落子的横纵坐标
        int x = chess.getX();
        int y = chess.getY();
        Color color = chess.getColor();

        //水平方向
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
            return true;
        }

        isFive = 1;
        return false;

    }

    private boolean isWin2(Chess chess) {
        //先获取当前落子的横纵坐标
        int x = chess.getX();
        int y = chess.getY();
        Color color = chess.getColor();


        //垂直方向
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
            return true;
        }
        isFive = 1;

        return false;

    }

    private boolean isWin3(Chess chess) {
        //先获取当前落子的横纵坐标
        int x = chess.getX();
        int y = chess.getY();
        Color color = chess.getColor();

        //右斜向上方向
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
            return true;
        }

        isFive = 1;
        return false;

    }

    private boolean isWin4(Chess chess) {
        //先获取当前落子的横纵坐标
        int x = chess.getX();
        int y = chess.getY();
        Color color = chess.getColor();

        //左斜向下方向
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

//for (int i = x+1;i <= x+4 && i < 19;i++){
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
            return true;
        }

        isFive = 1;
        return false;

    }


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


}
