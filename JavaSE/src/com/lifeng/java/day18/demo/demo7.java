package com.lifeng.java.day18.demo;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 从键盘获取一行输入字符串，要求去除重复字符。
 * @author lifeng
 * @create 2022-07-13 14:38
 */
public class demo7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一行字符串");
        String str = scanner.next();
        System.out.println("去重前："+str);
        System.out.println("去重后的字符串为："+quChong(str));

    }

    public static String quChong(String s){
        HashSet<String> strings = new HashSet<>();
        String[] replace = s.split("");
        for (int i = 0; i < replace.length; i++) {
            strings.add(replace[i]);
        }
        String newstr = "";
        for (String string : strings) {
            newstr += string;
        }
        return newstr;
    }

}
