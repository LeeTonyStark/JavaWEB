package com.lifeng.java.day23.demo;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * @author lifeng
 * @create 2022-07-20 16:21
 */
public class demo12 {
    public static void main(String[] args) throws Exception{
        PrintWriter pw = new PrintWriter(new FileWriter("ccc.txt"),true);
        pw.println("我爱你无可非难鸾凤分飞");
        pw.println("我爱你无可非难鸾凤分飞");
        pw.close();
    }
}
