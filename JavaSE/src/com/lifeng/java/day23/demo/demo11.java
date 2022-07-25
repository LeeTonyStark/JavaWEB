package com.lifeng.java.day23.demo;

import java.io.PrintWriter;

/**
 * @author lifeng
 * @create 2022-07-20 15:43
 */
public class demo11 {
    public static void main(String[] args) throws Exception{
        PrintWriter pw = new PrintWriter("ccc.txt");
        pw.write("啦啦啦啦啦啦啦");
        pw.flush();
        pw.close();
    }
}
