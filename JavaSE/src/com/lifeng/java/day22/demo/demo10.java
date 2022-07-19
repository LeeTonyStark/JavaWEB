package com.lifeng.java.day22.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * @author lifeng
 * @create 2022-07-19 17:09
 */
public class demo10 {
    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new FileWriter("ddd.txt"));//写入到ddd.txt文件
        bw.write("醉里挑灯看剑");
        bw.newLine();
        bw.write("梦回吹角连营");
        bw.newLine();
        bw.write("八百里分麾下炙");

        bw.flush();
        bw.close();
    }
}
