package com.lifeng.java.day22.demo;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author lifeng
 * @create 2022-07-19 17:22
 */
public class demo11 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("aaa.txt"));
        String len = null;
        while ((len=br.readLine()) != null){
            System.out.println(len);
        }

        br.close();

    }
}
