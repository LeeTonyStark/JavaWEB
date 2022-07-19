package com.lifeng.java.day22.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 文件复制：使用高效流
 *  方式一：
 * @author lifeng
 * @create 2022-07-19 10:49
 */
public class demo3 {
    public static void main(String[] args) throws Exception{
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("bbb.txt"));
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("aaa.txt"));
        int len = 0;
        while ((len = bis.read()) != -1){
            bos.write(len);
        }

        bos.flush();
        bos.close();
        bis.close();

    }
}
