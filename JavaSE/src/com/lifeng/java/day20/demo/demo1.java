package com.lifeng.java.day20.demo;

import java.io.File;
import java.io.IOException;

/**
 * @author lifeng
 * @create 2022-07-15 10:50
 */
public class demo1 {
    public static void main(String[] args) throws IOException {

        File file = new File("aaa");
//        file.createNewFile();//createNewFile()：创建文件
//        System.out.println(file.mkdirs());//mkdirs():创建文件夹
//        System.out.println(file.delete());//delete():删除文件夹
//        System.out.println(file.isFile());//ifFile():判断是否是文件
//        System.out.println(file.exists());//判断xxx文件或文件夹是否存在
//        System.out.println(file.isDirectory());//判断是否是文件夹

//        String name = file.getName();
//        System.out.println(name);//获取文件或者文件夹名
//
//        String absolutePath = file.getAbsolutePath();
//        System.out.println(absolutePath);//绝对路径
//
//        String path = file.getPath();
//        System.out.println(path);//获取文件或者文件夹的路径

        long length = file.length();
        System.out.println(length);//获取文件的长度

        File[] files = file.listFiles();
        for (File file1 : files) {
            System.out.println(file1.getAbsolutePath());
        }

    }
}
