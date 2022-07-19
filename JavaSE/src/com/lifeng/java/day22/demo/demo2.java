package com.lifeng.java.day22.demo;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author lifeng
 * @create 2022-07-19 10:45
 */
public class demo2 {
    public static void main(String[] args) throws Exception {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("aaa.txt"));
        int read = bis.read();
        System.out.println(read);
    }
}
