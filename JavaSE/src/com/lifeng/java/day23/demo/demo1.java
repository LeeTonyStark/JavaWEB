package com.lifeng.java.day23.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author lifeng
 * @create 2022-07-20 11:45
 */
public class demo1 {
    public static void main(String[] args) throws Exception{
        //一次读取一个字符，一次写入一个字符
        BufferedWriter bw = new BufferedWriter(new FileWriter("bbb.txt"));
        BufferedReader br = new BufferedReader(new FileReader("aaa.txt"));

        int len = 0;
        while ((len = br.read()) != -1){
            bw.write(len);
        }

        br.close();
        bw.close();

    }
}
