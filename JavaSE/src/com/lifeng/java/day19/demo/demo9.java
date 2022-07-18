package com.lifeng.java.day19.demo;

import java.io.File;

/**
 * @author lifeng
 * @create 2022-07-14 17:03
 */
public class demo9 {
    public static void main(String[] args) {
        //构造一
        File file1 = new File("D:\\电脑桌面\\测试.txt");

        //构造二：
        File file2 = new File("D:\\电脑桌面","测试.txt");

        //构造三：
        File file3 = new File("D:\\电脑桌面");
        File file4 = new File(file3,"测试.txt");

        System.out.println(file1);
        System.out.println(file2);
        System.out.println(file4);

    }
}
