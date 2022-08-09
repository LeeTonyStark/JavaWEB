package com.lifeng.java.gobang.message;

import java.io.Serializable;

/**
 * @author lifeng
 * @create 2022-07-30 0:05
 */
public class ChessMessage extends Message implements Serializable {
    private int x;//棋子x坐标
    private int y;//棋子y坐标
    private boolean isBlack;//是否黑子

    public ChessMessage() {
    }

    public ChessMessage(int x, int y, boolean isBlack) {
        this.x = x;
        this.y = y;
        this.isBlack = isBlack;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isBlack() {
        return isBlack;
    }

    public void setBlack(boolean black) {
        isBlack = black;
    }

    @Override
    public String toString() {
        return "ChessMessage{" +
                "x=" + x +
                ", y=" + y +
                ", isBlack=" + isBlack +
                '}';
    }
}
