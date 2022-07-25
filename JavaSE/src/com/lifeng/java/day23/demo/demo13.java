package com.lifeng.java.day23.demo;

import java.io.*;

/**
 * @author lifeng
 * @create 2022-07-20 16:34
 */
public class demo13 {
    public static void main(String[] args) throws Exception{
        //复制文件方式一：使用PrintWriter

        BufferedReader br = new BufferedReader(new FileReader("aaa.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("bbb.txt"),true);
        String s = null;
        while ((s = br.readLine()) != null){
            pw.println(s);
        }

        br.close();
        pw.close();
    }
}
