package com.lifeng.java.day20.exer;

import java.io.File;
import java.io.IOException;

/**
 * 1.在桌面上创建一个名字叫做aaa/bbb/ccc/aaa.txt？
 * @author lifeng
 * @create 2022-07-16 9:06
 */
public class exer1 {
    public static void main(String[] args) throws IOException {


        File file = new File("D:\\电脑桌面\\aaa\\bbb\\ccc\\aaa.txt");

        if (file.mkdirs()){
            if (file.isDirectory()){
                file.delete();
                file.createNewFile();
            }
        }

    }
}
