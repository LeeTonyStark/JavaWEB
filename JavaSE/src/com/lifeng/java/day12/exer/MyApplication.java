package com.lifeng.java.day12.exer;

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

public class MyApplication extends Application{
	private final int checkerBoardHeight = 600;
	private final int checkerBoardWidth = 600;
	private final int padd = 40;//格子间隔
	private final int margin = 40;//棋盘边缘留白
	private final int lineCount = 13+1;//横线竖线数量
	private boolean isBlack = true;//用以控制黑白子交替，默认黑子优先
	private Chess[] chessLocation = new Chess[lineCount * lineCount];//记录棋子每次落子位置
	private int chessCount = 0;//记录落子个数
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		
		//创建大舞台 对象
		stage.show();
		//获取画板对象
		Pane pane = getPane();
		//给画板绑定鼠标事件，我们一用鼠标点击画板，就会执行某些操作
		pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
			//当鼠标点击画板，就会执行该方法
			@Override
			public void handle(MouseEvent event) {
				//获取鼠标点击点的x和y坐标
				double x = event.getX();
				double y = event.getY();
				//用鼠标点击的坐标计算并设置棋子的横纵坐标
				int chessX = 0, chessY = 0;
					chessX = ((int)x - margin + padd/2)/padd;//棋子落子横坐标
					chessY = ((int)y - margin + padd/2)/padd;//棋子落子纵坐标
//				if(!(x >= margin && x <= checkerBoardWidth - margin && y >= margin && y <= checkerBoardHeight - margin)) {
//					return;
//				}
				//创建棋子对象
				Chess chess = null;
//				chess.setChessX(chessX * padd + margin);//棋子横坐标
//				chess.setChessY(chessY * padd + margin);//棋子纵坐标
				//在落子前判断本次落子位置是否已经有棋子
				if(isHasChess(chessX,chessY)) {
					return;
				}
					//判断落黑子还是白子，并在棋盘上落子
					if(isBlack) {
						//创建圆圈对象，即棋子
						Circle circle = new Circle(chess.getChessX(), chess.getChessY(),10, Color.BLACK);
						//将圆圈对象放到画板上
						pane.getChildren().add(circle);
						isBlack = !isBlack;
						chess = new Chess(chessX,chessY,Color.BLACK);
						chessLocation[chessCount] = chess;
//						System.out.println(chessLocation[chessCount].getChessX());
//						System.out.println(chessLocation[chessCount].getChessX());
						chessCount++;
					}else if(!isBlack){
						//创建圆圈对象，即棋子
						Circle circle = new Circle(chess.getChessX(), chess.getChessY(), 10, Color.WHITE);
						//将圆圈对象放到画板上
						pane.getChildren().add(circle);
						isBlack = !isBlack;
						//将本次落子记录到chessLocation[]中
						chess = new Chess(chessX,chessY,Color.BLACK);
						chessLocation[chessCount] = chess;
//						System.out.println(chessLocation[chessCount].getChessX());
//						System.out.println(chessLocation[chessCount].getChessX());
						chessCount++;
					}


//				}

			}
		});
		
		//创建场景对象，并将画板对象放到场景中
		Scene scene = new Scene(pane,checkerBoardHeight,checkerBoardWidth);
		//将场景对象放到大舞台对象中
		stage.setScene(scene);
	}
	
	//创建画板对象，封装，将各个东西扔到画板上
	private Pane getPane() {
		//创建画板 对象
		Pane pane =  new Pane();
		//设置画板背景颜色
		pane.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));
		
		/*第二种方法画棋盘*/
		for(int i = 1, padding = margin; i <= lineCount; i++) {
			//画横线
			Line rowLine = new Line(margin, padding, checkerBoardWidth-margin, padding);
			pane.getChildren().add(rowLine);
			//画竖线
			Line colLine = new Line(padding, margin, padding, checkerBoardHeight-margin);
			pane.getChildren().add(colLine);
			padding = padding + padd;
		}
		return pane;
	}
	
	//启动
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * 判断本次落子位置是否已经有棋子
	 * @param x		棋子横坐标
	 * @param y		棋子纵坐标
	 * @return		返回是否有棋子的标志，true表示有棋子，flase表示没有棋子
	 */
	public boolean isHasChess(int x, int y) {
	
		for(int i = 0; i <= chessLocation.length; i++) {
			Chess chess = chessLocation[i];
			if(chess.getChessX() == x && chess.getChessY() == y) {
				return true;
			}
		}
		return false;
	}
	
}
