package com.lifeng.java.day14.demo;

import java.util.Random;

/**
 * @author lifeng
 * @create 2022-07-07 14:54
 */
public class demo4 {
    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt(100);//[0,100)
        i += 1;
        System.out.println(i);

    }
}
