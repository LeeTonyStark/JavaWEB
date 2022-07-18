package com.lifeng.java.day12.exer;

import java.util.Scanner;

/**
 * 7.需求：键盘接收一个字符串，程序判断出该字符串是否是对称字符串，并在控制台打印是或不是
 * 			对称字符串：123321,111
 * 			非对称字符串：123123
 * @author lifeng
 * @create 2022-07-05 20:53
 */
public class exer8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();

        char[] chars = next.toCharArray();
        String s = "";
        for (int i = chars.length - 1;i >= 0 ; i--) {
            s += chars[i];
        }

        if (next.equals(s)){
            System.out.println("这是一个对称字符串");
        }else{
            System.out.println("这不是一个对称字符串");
        }
    }
}
