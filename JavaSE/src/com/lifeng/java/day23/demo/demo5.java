package com.lifeng.java.day23.demo;

import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author lifeng
 * @create 2022-07-20 14:27
 */
public class demo5 {
    public static void main(String[] args) throws Exception{
        InputStreamReader isr = new InputStreamReader(new FileInputStream("aaa.txt"));
        int ch = 0;
        while ((ch = isr.read()) != -1){
            System.out.print((char) ch);
        }

        isr.close();
    }
}
