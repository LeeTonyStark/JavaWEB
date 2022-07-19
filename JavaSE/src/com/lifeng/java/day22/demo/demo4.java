package com.lifeng.java.day22.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author lifeng
 * @create 2022-07-19 11:18
 */
public class demo4 {
    public static void main(String[] args) throws Exception{
        //创建高效字节输入流对象
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("aaa.txt"));
        //创建高效字节输出流对象
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("ccc.txt"));
        //一次读取一个字节数组，一次写出一个字节数组的一部分
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = bis.read(bytes)) != -1){
            bos.write(bytes,0,len);
        }
        //释放资源
        bos.flush();
        bos.close();
        bis.close();
    }
}
