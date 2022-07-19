package com.lifeng.java.day22.demo;

import java.io.FileReader;

/**
 * @author lifeng
 * @create 2022-07-19 16:15
 */
public class demo8 {
    public static void main(String[] args) throws Exception{
        FileReader fr = new FileReader("aaa.txt");
        int len = 0;
        char[] chars = new char[1024];
        while ((len=fr.read(chars)) != -1){
            System.out.println((char)len);
        }
        fr.close();
    }
}
