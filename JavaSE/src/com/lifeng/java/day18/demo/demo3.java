package com.lifeng.java.day18.demo;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

/**
 * 生成10个1到20之间的不重复的随机数
 * @author lifeng
 * @create 2022-07-13 12:13
 */
public class demo3 {
    public static void main(String[] args) {
//        Random random = new Random();//使用Random类
        HashSet<Integer> integers = new HashSet<>();
        System.out.println();

        while (integers.size() < 10){
            integers.add((int)(Math.random() * 20) + 1 );
        }

        for (Integer integer : integers) {
            System.out.println(integer);
        }

    }
}
