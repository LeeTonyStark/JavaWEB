package com.lifeng.java.day13.exer;

import java.util.Scanner;

/**
 * @author lifeng
 * @create 2022-07-06 11:20
 */
public class exer2 {
    public static void main(String[] args) {

        //1.反转abcde
//        String s = "abcde";
//        StringBuilder stringBuilder = new StringBuilder(s);
//        StringBuilder reverse = stringBuilder.reverse();
//        System.out.println(reverse);

        //2.
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个对称字符串");
        String next = scanner.next();
        StringBuilder stringBuilder = new StringBuilder(next);
        stringBuilder.reverse();
        if (stringBuilder.toString().equals(next)) {
            System.out.println("是");
        }else {
            System.out.println("否");
        }
    }
}
