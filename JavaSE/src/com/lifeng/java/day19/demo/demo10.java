package com.lifeng.java.day19.demo;

import java.io.File;
import java.io.IOException;

/**
 * @author lifeng
 * @create 2022-07-14 17:23
 */
public class demo10{
    public static void main(String[] args) throws IOException {
        File file = new File("aaa.txt");
//        boolean newFile = file.createNewFile();
//        System.out.println(newFile);
//
//        boolean mkdir = file.mkdir();
//        System.out.println(mkdir);

//        File file1 = new File("bbb");
//        System.out.println(file1.mkdirs());
        System.out.println(file.delete());
    }
}
