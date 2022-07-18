package com.lifeng.java.day21.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author lifeng
 * @create 2022-07-18 14:24
 */
public class demo4 {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fim = new FileInputStream(new File("aaa.txt"));
        FileInputStream fim1 = new FileInputStream("aaa.txt");
        System.out.println(fim1);

    }
}
