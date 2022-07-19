package com.lifeng.java.day21.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author lifeng
 * @create 2022-07-18 14:37
 */
public class demo5 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("user.txt");
        int by = fis.read();
//        System.out.println(by);

        while (by != -1){
            System.out.println((char) by);
            fis.read();
        }


    }
}
