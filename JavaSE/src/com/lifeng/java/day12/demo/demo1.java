package com.lifeng.java.day12.demo;

/**
 * String的构造器练习
 * @author lifeng
 * @create 2022-07-05 14:26
 */
public class demo1 {
    public static void main(String[] args) {

        String s1 = new String();
        System.out.println(s1);//打印空串

        byte[] bytes = {65,66,67,68};
        String s2 = new String(bytes);//将字节类型的字节数组转换为字符串

        String s3 = new String(bytes,1,2);

        System.out.println("***" + s2 + "****" + s3);

        char[] chars = {'a','b','c'};
        String s = new String(chars);
        System.out.println(s);

        String s4 = new String(chars, 0, 2);
        System.out.println(s4);

        String s5 = "ssssss";

        String s6 = new String(s5);

        System.out.println(s5);

        System.out.println(s6);

    }
}
