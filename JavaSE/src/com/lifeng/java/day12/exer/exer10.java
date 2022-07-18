package com.lifeng.java.day12.exer;

import java.util.Scanner;

/**
 * 9.需求：猜数字小游戏，通过Math.random()随机生成一个1-100之间的随机整数，
 * 我们就通过键盘录入我们猜的数字，
 * 看一看对不对，如果不对，继续猜，直到猜对位置
 * @author lifeng
 * @create 2022-07-05 21:12
 */
public class exer10 {

    public static void main(String[] args) {

        int random = (int)(Math.random()*100)+1;
//        System.out.println(random);
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        while (!(num==random)){
            num = scanner.nextInt();
            System.out.println(random);
            System.out.println("恭喜你，猜错了");
            if (num==random){
                System.out.println("恭喜你，猜对了！！！！！");
                return;
            }
        }
    }
}
