package com.lifeng.java.day22.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author lifeng
 * @create 2022-07-19 15:33
 */
public class demo7 {
    public static void main(String[] args) throws IOException {
        //FileWriter(File file)
//        FileWriter fileWriter = new FileWriter(new File("a.txt"));
//        File file = new File("a.txt");
//        file.delete();
//        FileWriter fileWriter = new FileWriter("a.txt");

        FileWriter fw = new FileWriter("aaa.txt",true);
//        char[] chars = {'a','b','c'};
        String s = "一生一世";
        char[] chars = s.toCharArray();
        fw.write(chars);
        fw.flush();//刷新
        fw.close();
    }
}
