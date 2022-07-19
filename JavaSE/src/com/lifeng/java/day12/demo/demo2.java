package com.lifeng.java.day12.demo;

/**
 * @author lifeng
 * @create 2022-07-05 14:42
 */
public class demo2 {

    public static void main(String[] args) {

        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);

        String s4 = "ABC";
        String s5 = "AB";
        String s6 = s5 + "C";
        System.out.println(s4 == s6);

    }

}
