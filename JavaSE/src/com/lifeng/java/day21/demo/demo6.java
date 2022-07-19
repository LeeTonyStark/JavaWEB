package com.lifeng.java.day21.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * FileInputStream类
 * @author lifeng
 * @create 2022-07-18 14:47
 */
public class demo6 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("user.txt");
//        byte[] bytes = new byte[2];
//        int read = fis.read(bytes);
//        System.out.println("读取长度是"+read);
//        System.out.println(Arrays.toString(bytes));
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read(bytes)) != -1){
            //将字节数组转换成字符串
            System.out.println(new String(bytes,0,len));
        }
    }
}
