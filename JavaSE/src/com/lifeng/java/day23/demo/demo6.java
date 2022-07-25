package com.lifeng.java.day23.demo;

import java.io.*;

/**
 文件复制
 * @author lifeng
 * @create 2022-07-20 14:35
 */
public class demo6 {
    public static void main(String[] args) throws Exception {
        //一次读取一个字符，一次写出一个字符
        InputStreamReader isr = new InputStreamReader(new FileInputStream("aaa.txt"));
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("bbb.txt"));

        int ch = 0;
        while ((ch = isr.read()) != -1){
            osw.write(ch);
            osw.flush();
        }

        isr.close();
        osw.close();
    }
}
