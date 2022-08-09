package com.lifeng.java.gobang.pojo;

import javafx.scene.paint.Color;

import java.util.Objects;

/**
 * @author lifeng
 * @create 2022-07-04 19:53
 */
public class Chess {
    private int x;
    private int y;
    private Color color;

    public Chess() {
    }

    public Chess(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Chess{" +
                "x=" + x +
                ", y=" + y +
                ", color=" + color +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chess)) return false;
        Chess chess = (Chess) o;
        return x == chess.x && y == chess.y && Objects.equals(color, chess.color);
    }

}
