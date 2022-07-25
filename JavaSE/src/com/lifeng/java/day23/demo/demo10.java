package com.lifeng.java.day23.demo;

import java.io.*;

/**
 * @author lifeng
 * @create 2022-07-20 14:51
 */
public class demo10 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("aaa.txt")));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("bbb.txt")));
        int ch = 0;
        char[] chars = new char[1024];
        while ((ch = br.read(chars)) != -1){
            bw.write(chars,0,ch);
            bw.flush();
        }
        br.close();
        bw.close();
    }
}
