package com.lifeng.java.day22.demo;

import java.io.*;

/**
 * @author lifeng
 * @create 2022-07-19 10:27
 */
public class demo1 {
    public static void main(String[] args) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("aaa.txt"));
        bos.write('b');
        bos.flush();//字符缓冲输出流，将输出数据放到缓冲区，需要先刷新数据再进行写入

    }
}
