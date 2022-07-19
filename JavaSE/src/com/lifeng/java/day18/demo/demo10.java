package com.lifeng.java.day18.demo;

import java.util.HashSet;

/**
 * 编写程序，获取命令行参数中的字符串列表，输出其中重复的字符、不重复的字符以及消除重复以后的字符列表
 * @author lifeng
 * @create 2022-07-13 16:55
 */
public class demo10 {
    public static void main(String[] args) {
        String s = "abcdeafblmbnopawc";
        System.out.println("原字符串为："+s);

        HashSet<String> str1 = new HashSet<>();//
        HashSet<String> str2 = new HashSet<>();//
        HashSet<String> str3 = new HashSet<>();//利用HashSet的去重特性，存储去除重复后的字符串

    }
}
