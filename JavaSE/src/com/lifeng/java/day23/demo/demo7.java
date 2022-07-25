package com.lifeng.java.day23.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author lifeng
 * @create 2022-07-20 14:41
 */
public class demo7 {
    public static void main(String[] args) throws Exception{
        InputStreamReader isr = new InputStreamReader(new FileInputStream("aaa.txt"));
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("bbb.txt"));
        int len = 0;
        char[] chars = new char[1024];
        while ((len = isr.read(chars)) != -1){
            osw.write(chars,0,len);
            osw.flush();
        }

        isr.close();
        osw.close();
    }
}
