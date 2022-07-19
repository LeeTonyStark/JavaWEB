package com.lifeng.java.day21.demo;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * BufferedOutputStream类的使用
 * @author lifeng
 * @create 2022-07-18 16:50
 */
public class demo10 {
    public static void main(String[] args) throws Exception {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("ddd.txt"));
    }
}
