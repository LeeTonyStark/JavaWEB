package com.lifeng.java.day21.demo;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author lifeng
 * @create 2022-07-18 12:14
 */
public class demo2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("aaa.txt");
//        fos.write(97);
        byte[] b ={97,98,99,100,101};
//        fos.write(b);
        fos.write(b,0,3);//第一个参数是字节数组，第二个参数是索引开始下标，第三个参数是放进去的长度。
    }
}
