package com.lifeng.java.day12.exer;

import java.util.Scanner;

/**
 * 5.需求：键盘录入一个字符串，如果字符串中包含(TMD),则使用***替换
 * @author lifeng
 * @create 2022-07-05 20:39
 */
public class exer6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String s = scanner.next();

        if (s.contains("TMD")){
            String tmd = s.replace("TMD", "***");
            System.out.println(tmd);
        }
    }
}
