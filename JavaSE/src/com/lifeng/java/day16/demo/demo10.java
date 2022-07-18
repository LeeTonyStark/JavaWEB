package com.lifeng.java.day16.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author lifeng
 * @create 2022-07-11 15:21
 */
public class demo10 {
    public static void main(String[] args) {
        File file = new File("\u202AD:\\电脑桌面\\test.txt");
        //创建字节写出流对象 第二个参数默认false 覆盖原文件文本，改为true则追加在原文件文本后

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file, true);
            //
            //fileOutputStream.write(97);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
