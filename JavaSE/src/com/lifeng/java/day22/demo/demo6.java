package com.lifeng.java.day22.demo;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author lifeng
 * @create 2022-07-19 15:07
 */
public class demo6 {
    public static void main(String[] args) throws UnsupportedEncodingException {

        //编码
        String s = "我爱你";
        byte[] bytes = s.getBytes("gbk");
        //使用Arrays类的toString()方法来将字节数组以字符串形式表示
        System.out.println(Arrays.toString(bytes));

        //解码
//        byte[] bytes1 = {-27, -118, -96, -27, -81, -122, -23, -128, -102, -24, -81, -99};
//        String s1 = new String(bytes1,"utf-8");
//        System.out.println(s1);

    }
}
