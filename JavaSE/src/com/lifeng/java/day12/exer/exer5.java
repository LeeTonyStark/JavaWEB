package com.lifeng.java.day12.exer;

import java.util.Scanner;

/**
 * 4.需求：以字符串的形式从键盘接收一个手机号，将中间四位号码屏蔽，最终效果为：156****1234
 * @author lifeng
 * @create 2022-07-05 20:17
 */
public class exer5 {
    public static void main(String[] args) {
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入一个电话号码：");
            String number = scanner.next();
            if (number.length() == 11){
                //找出要替换的数字
                String substring = number.substring(3, 7);
                String replace = number.replace(substring, "****");
                System.out.println(replace);
                return;
            }else {
                System.out.println("号码应为11位");
                return;
            }
        }
    }
}
