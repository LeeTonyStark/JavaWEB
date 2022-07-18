package com.lifeng.java.day18.exer;

import java.util.HashSet;

/**
 * @author lifeng
 * @create 2022-07-13 20:23
 */
public class exer5 {
    public static void main(String[] args) {
        HashSet<Integer> integers = new HashSet<>();

        while (integers.size() < 10){
            integers.add((int)(Math.random() * 20) + 1 );
        }

        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
