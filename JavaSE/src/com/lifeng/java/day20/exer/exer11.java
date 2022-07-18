package com.lifeng.java.day20.exer;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author lifeng
 * @create 2022-07-16 14:35
 */
public class exer11 {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int num1 = o2 - o1;
                int num2 = num1 == 0 ? 1 : num1;
                return num2;
            }
        });

        while (set.size() < 10){
            int num = (int)(Math.random()*50)+1;
            if (num%2==0)
            set.add(num);
        }

        System.out.println(set);
        StringBuilder stringBuilder = new StringBuilder("(");
        for (Integer integer : set) {
            stringBuilder.append(integer + ",");

        }
        String substring = stringBuilder.substring(0, stringBuilder.length() - 1);
        System.out.println(substring+")");

    }
}
