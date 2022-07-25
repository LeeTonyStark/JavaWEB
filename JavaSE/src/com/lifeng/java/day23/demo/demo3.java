package com.lifeng.java.day23.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author lifeng
 * @create 2022-07-20 11:54
 */
public class demo3 {
    public static void main(String[] args) throws Exception{
        //一次读取一行，一次写入一行
        BufferedWriter bw = new BufferedWriter(new FileWriter("bbb.txt"));
        BufferedReader br = new BufferedReader(new FileReader("aaa.txt"));

        String s = null;
        while ((s = br.readLine()) != null){
            bw.write(s);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
