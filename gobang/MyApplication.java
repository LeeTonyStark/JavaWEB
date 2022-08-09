package com.lifeng.java.gobang;

import com.lifeng.java.gobang.ui.single.SingleUI;
import com.lifeng.java.gobang.ui.web.MessageUI;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Optional;

/**
 * 五子棋项目
 *      -----启动类
 * @author lifeng
 * @create 2022-06-30 11:32
 */
public class MyApplication extends Application {

    private Stage stage = null;

    public static void main(String[] args) {
        //启动
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        this.stage = stage;

        //创建画板对象
        Pane pane = new Pane();

        //创建场景对象,并且将画板放到场景上
        Scene scene = new Scene(pane,500,220);

        //创建单机版按钮
        Button singleUIButton = getSingleUI();

        //创建网络版按钮
        Button getWebUIButton = getWebUI();

        //将按钮添加到画板上
        pane.getChildren().addAll(singleUIButton,getWebUIButton);

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

        //将场景设置到舞台上
        stage.setTitle("五子棋小游戏");//设置窗口的名字
        stage.setResizable(true);//窗口可以改变大小
        stage.setScene(scene);

        //展示舞台
        stage.show();

    }


    /**
     * 网络版单击按钮
     * @return
     */
    private Button getWebUI() {
        Button webButton = new Button("网络版");
        webButton.setPrefSize(100,90);
        webButton.setLayoutX(290);
        webButton.setLayoutY(55);

        webButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //创建信息界面对象
                MessageUI messageUI = new MessageUI();
                //展示信息界面
                messageUI.show();
                //关闭当前界面
                stage.close();
            }
        });

        return webButton;
    }

    /**
     * 单机版点击按钮
     * @return
     */
    private Button getSingleUI() {
        Button singleButton = new Button("单机版");
        singleButton.setPrefSize(100,90);
        singleButton.setLayoutX(90);
        singleButton.setLayoutY(55);
        //单机版点击事件
        singleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //创建单机版游戏界面对象
                SingleUI singleUI = new SingleUI();
                //展示单击界面
                singleUI.show();
                //关闭当前窗口
                stage.close();
            }
        });

        return singleButton;
    }
}
