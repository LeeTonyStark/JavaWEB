package com.lifeng.java.day21.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件的复制
 *  方式一：一次读取一个字节。一次写出一个字节
 * @author lifeng
 * @create 2022-07-18 15:12
 */
public class demo7 {
    public static void main(String[] args) throws IOException {
        //创建普通字节输入流对象
        FileInputStream fileInputStream = new FileInputStream("aaa.txt");

        //创建普通字节输出流对象
        FileOutputStream fileOutputStream = new FileOutputStream("bbb.txt");

        //一次读取一个字节。一次写出一个字节
        int by = 0;
        while ((by = fileInputStream.read()) != -1){//每次读一个字节
            fileOutputStream.write(by);//把读出来的字节用输出流输出到bbb.txt
        }

        fileInputStream.close();//
        fileOutputStream.close();

    }
}
