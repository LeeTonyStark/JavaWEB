package com.lifeng.java.day23.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * @author lifeng
 * @create 2022-07-20 14:15
 */
public class demo4 {
    public static void main(String[] args) throws Exception{
        //转换输出流
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("ccc.txt"));
        osw.write("das");
        osw.flush();
    }
}
