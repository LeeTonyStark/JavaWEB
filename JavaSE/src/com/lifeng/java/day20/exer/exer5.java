package com.lifeng.java.day20.exer;

import java.io.File;

/**
 * 5.从键盘接收一个文件夹路径,统计该文件夹大小，并输出结果(文件夹路径下没有子文件夹)
 * @author lifeng
 * @create 2022-07-16 11:23
 */
public class exer5 {
    public static void main(String[] args) {
        File file = new File("aaa\\bbb");
        Long len = 0L;//存储文件的长度
        for (File listFile : file.listFiles()) {
//            System.out.println(listFile.getName());
            len += listFile.length();
        }

        System.out.println("该文件有" + len + "字节");
    }
}
