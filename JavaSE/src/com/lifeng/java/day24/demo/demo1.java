package com.lifeng.java.day24.demo;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @author lifeng
 * @create 2022-07-21 9:49
 */
public class demo1 {
    public static void main(String[] args) throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ccc.txt"));
        System.out.println(ois.readObject());
    }
}
