package com.lifeng.java.day23.demo;

import java.io.*;

/**
 * @author lifeng
 * @create 2022-07-20 14:51
 */
public class demo9 {
    public static void main(String[] args) throws Exception{
        InputStreamReader isr = new InputStreamReader(new BufferedInputStream(new FileInputStream("aaa.txt")));
        OutputStreamWriter osw = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream("bbb.txt")));
        int ch = 0;
        char[] chars = new char[1024];
        while ((ch = isr.read(chars)) != -1){
            osw.write(chars,0,ch);
            osw.flush();
        }


        isr.close();
        osw.close();
    }
}
