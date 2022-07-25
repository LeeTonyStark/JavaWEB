package com.lifeng.java.day23.demo;

import java.io.*;

/**
 * @author lifeng
 * @create 2022-07-20 14:45
 */
public class demo8 {
    public static void main(String[] args) throws Exception{
        InputStreamReader isr = new InputStreamReader(new BufferedInputStream(new FileInputStream("aaa.txt")));
        OutputStreamWriter osw = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream("bbb.txt")));
        int ch = 0;
        while ((ch = isr.read()) != -1){
            osw.write(ch);
            osw.flush();
        }

        isr.close();
        osw.close();

    }
}
