package com.lifeng.java.day12.exer;

import java.util.Scanner;

/**
 * 3.需求: 键盘录入一个字符串，统计该字符串中大写字母字符，小写字母字符，数字字符出现的次数(不考虑其他字符)
 * @author lifeng
 * @create 2022-07-05 19:52
 */
public class exer4 {

    public static void main(String[] args) {

//定义变量统计大小写字母和数字出现的次数
        int uppercaseCount = 0;//大写字母出现次数
        int lowercaseCount = 0;//小写字母出现次数
        int numCount = 0;//数字出现次数
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String next = scan.next();


        //数字ASCII范围是48-57
        //大写字母ASCII范围是65-90
        //小写字母ASCII范围是97-122
        //先转换成字节码
        byte[] bytes = next.getBytes();
        for (int i = 0;i < bytes.length;i++){
            if (bytes[i] >= 48 && bytes[i] <= 57){
                    numCount++;
            }else if (bytes[i] >= 65 && bytes[i] <= 90){
                    lowercaseCount++;
            }else {
                    uppercaseCount++;
            }
        }

        System.out.println("大写字母出现次数：" + uppercaseCount);
        System.out.println("小写字母出现次数：" + lowercaseCount);
        System.out.println("数字出现次数：" + numCount);

    }
}
