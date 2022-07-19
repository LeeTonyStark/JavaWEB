package com.lifeng.java.day22.demo;

import java.io.*;

/**
 * 使用高效字节输入流和高效字节输出流操作复制文件
 * @author lifeng
 * @create 2022-07-19 14:27
 */
public class demo5 {
    public static void main(String[] args) throws Exception {
        //方式一:一次读入一个字节，一次读出一个字节
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("456.jpg"));
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("123.jpg"));
//        int len = 0;//记录读入字节
//        while((len=bis.read()) != -1){
//            bos.write(len);
//        }
//
//        bos.flush();
//        bos.close();
//        bis.close();
//        System.out.println("复制成功");

        //方式二：一次读入1024个字节，一次读出一部分字节
        int len = 0;//记录读入的字节数
        byte[] bytes = new byte[1024];
        while ((len = bis.read(bytes)) != -1){
            bos.write(len);
        }

        System.out.println("复制成功");

        bos.flush();
        bos.close();
        bis.close();

    }
}
