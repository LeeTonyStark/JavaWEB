package com.lifeng.java.day12.exer;

import javafx.scene.paint.Color;
/*
 * 棋子类
 */
public class Chess {
	private int chessX;
	private int chessY;
	private Color chessColor;

	public Chess() {
	}

	public Chess(int chessX, int chessY, Color chessColor) {
		this.chessX = chessX;
		this.chessY = chessY;
		this.chessColor = chessColor;
	}

	//
	public int getChessX() {
		return chessX;
	}
	public void setChessX(int chessX) {
		this.chessX = chessX;
	}
	public int getChessY() {
		return chessY;
	}
	public void setChessY(int chessY) {
		this.chessY = chessY;
	}
	public Color getChessColor() {
		return chessColor;
	}
	public void setChessColor(Color chessColor) {
		this.chessColor = chessColor;
	}

	@Override
	public String toString() {
		return "Chess{" +
				"chessX=" + chessX +
				", chessY=" + chessY +
				", chessColor=" + chessColor +
				'}';
	}
}
