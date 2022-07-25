package com.lifeng.java.day23.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author lifeng
 * @create 2022-07-20 11:51
 */
public class demo2 {
    public static void main(String[] args) throws Exception{
        //一次读入一个字符数组，一次写入一个字符数组
        BufferedWriter bw = new BufferedWriter(new FileWriter("bbb.txt"));
        BufferedReader br = new BufferedReader(new FileReader("aaa.txt"));

        int len = 0;
        char[] chars = new char[1024];
        while ((len =br.read(chars)) != -1){
            bw.write(chars,0,len);
        }

        br.close();
        bw.close();

    }
}
