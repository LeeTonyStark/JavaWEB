package com.lifeng.java.day21.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件的复制
 *    方式二：一次读取一个字节数组。一次写出一个字节数组的一部分(比第一种效率高)
 * @author lifeng
 * @create 2022-07-18 15:38
 */
public class demo8 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("aaa.txt");
        FileOutputStream fos = new FileOutputStream("ccc.txt");

        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read(bytes)) != -1){
            fos.write(bytes,0,len);
        }

        fis.close();
        fos.close();

    }
}
