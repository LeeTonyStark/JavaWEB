package com.lifeng.java.gobang.ui.web;

import com.lifeng.java.gobang.Global;
import com.lifeng.java.gobang.message.ChessMessage;
import com.lifeng.java.gobang.message.ClearMessage;
import com.lifeng.java.gobang.message.RetractMessage;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Optional;


/**
 * 网络版信息界面
 * @author lifeng
 * @create 2022-07-29 22:25
 */
public class MessageUI extends Stage {

    public MessageUI(){
        //创建画板
        Pane pane = new Pane();

        //创建文本
        Label mip = new Label("我 的 IP");
        mip.setLayoutX(20);
        mip.setLayoutY(60);
        Label mport = new Label("我的端口");
        mport.setLayoutX(20);
        mport.setLayoutY(110);
        Label oip = new Label("对 方 IP");
        oip.setLayoutX(20);
        oip.setLayoutY(160);
        Label oport = new Label("对方端口");
        oport.setLayoutX(20);
        oport.setLayoutY(210);

        //将文本添加到画板上
        pane.getChildren().addAll(mip,mport,oip,oport);

        //创建输入框
        TextField mip_text = new TextField();
        mip_text.setLayoutX(90);
        mip_text.setLayoutY(60);
        TextField mport_text = new TextField();
        mport_text.setLayoutX(90);
        mport_text.setLayoutY(110);
        TextField oip_text = new TextField();
        oip_text.setLayoutX(90);
        oip_text.setLayoutY(160);
        TextField oport_text = new TextField();
        oport_text.setLayoutX(90);
        oport_text.setLayoutY(210);

        //将输入框添加到画板上
        pane.getChildren().addAll(mip_text,mport_text,oip_text,oport_text);

        //创建确认按钮
        Button startButton = new Button("确认");
        startButton.setDefaultButton(true);//设置为默认按钮，点enter确定
        startButton.setLayoutX(40);
        startButton.setLayoutY(300);

        //给确定按钮创建单击事件
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //获取用户输入的IP和端口信息
                String mipText = mip_text.getText();
                int mportText = Integer.parseInt(mport_text.getText());
                String oipText = oip_text.getText();
                int oportText = Integer.parseInt(oport_text.getText());

                //将获取到的信息赋给全局变量(封装数据)
                Global.mipText = mipText;
                Global.mportText = mportText;
                Global.oipText = oipText;
                Global.oportText = oportText;

                System.out.println(mipText);

                //打开游戏界面
                WebUI webUI = new WebUI();
                webUI.show();

                //关闭当前窗口
                MessageUI.this.close();

                //接收端(接收发送端发送的棋子信息)----------接收端要放在线程里面，否则若发送端未启动，那么接收端会一直卡住--------------
                //创建线程后,主方法执行不会影响线程，是单独分开的互相不影响
                new Thread(){
                    @Override
                    public void run() {
                        ServerSocket serverSocket = null;
                        Socket accept = null;
                        try {
                            //1.创建ServerSocket对象
                            serverSocket = new ServerSocket(Global.mportText);
                            //2.监听连接
                            while (true){
                                accept = serverSocket.accept();
                                //3.创建管道输入流对象
                                ObjectInputStream ois = new ObjectInputStream(accept.getInputStream());
                                //4.处理数据
                                Object obj = ois.readObject();
                                //判断到底是哪个操作(落子,悔棋,再来一局...)
                                System.out.println(obj);
                                if (obj instanceof ChessMessage){//若传过来的数据是棋子信息类，就把它展示在棋盘上
                                    ChessMessage chessMessage = (ChessMessage) obj;
                                    //更改棋盘
                                    webUI.update(chessMessage);
                                }if (obj instanceof RetractMessage){//若传过来的对象信息是悔棋信息
                                    //TODO 悔棋
                                    RetractMessage rerract = (RetractMessage) obj;

                                    //创建弹框对象
//                                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//                                    alert.setTitle("是否悔棋");
//                                    alert.setHeaderText("你同意对方悔棋吗?");
//                                    //展示弹框
//                                    Optional<ButtonType> optional = alert.showAndWait();
//                                    if (optional.get() == ButtonType.OK){
                                        rerract.steFlag(RetractMessage.REPLAY_AGRRE);
//                                    }else {
//                                        rerract.steFlag(3);
//                                        event.consume();//执行此方法取消退出
//                                    }

                                    //将是否同意悔棋的信息反馈信息给对面
                                    ObjectOutputStream oos = new ObjectOutputStream(accept.getOutputStream());
                                    oos.writeObject(rerract);//将悔棋信息再反馈给对面

                                    Thread.sleep(100);

                                    webUI.RetractChess();

                                }if (obj instanceof ClearMessage){
                                    ClearMessage clearMessage = (ClearMessage) obj;

                                    clearMessage.setFlag(ClearMessage.ALLOW_CLEAR);//同意清空棋盘

                                    //将是否同意清空棋盘的信息反馈信息给对面
                                    ObjectOutputStream oos = new ObjectOutputStream(accept.getOutputStream());
                                    oos.writeObject(clearMessage);//将悔棋信息再反馈给对面

                                    Thread.sleep(100);

                                    webUI.ClearChess();

                                }

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }finally {
                            //5.关闭资源
//                    accept.close();
//                    serverSocket.close();
                        }
                    }
                }.start();

            }
        });

        //创建取消按钮
        Button quitButton = new Button("取消");
        quitButton.setLayoutX(200);
        quitButton.setLayoutY(300);

        //给取消按钮添加点击事件
        quitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MessageUI.this.close();
            }
        });

        //将按钮添加到画板上
        pane.getChildren().addAll(startButton,quitButton);

        //将画板添加到场景中
        Scene scene = new Scene(pane,300,400);
        //将场景设置到舞台中
        this.setScene(scene);
    }

}
