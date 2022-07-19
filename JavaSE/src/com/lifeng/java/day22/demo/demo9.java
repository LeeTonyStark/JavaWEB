package com.lifeng.java.day22.demo;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author lifeng
 * @create 2022-07-19 16:38
 */
public class demo9 {
    public static void main(String[] args) throws Exception{
        //一次读出一个字符，一次写入一个字符
//        FileReader fr = new FileReader("aaa.txt");
//        FileWriter fw = new FileWriter("bbb.txt");
//        int len = 0;
//        while ((len = fr.read()) != -1){
//            fw.write(len);
//        }
//
//        fw.close();
//        fr.close();
        //一次读出一个字符，一次写出一个字符
        FileReader fr = new FileReader("aaa.txt");
        FileWriter fw = new FileWriter("ccc.txt");
        int len = 0;
        char[] chars = new char[1024];
        while ((len = fr.read(chars)) != -1){
            fw.write(chars,0,len);
        }

        fw.close();
        fr.close();

    }
}
