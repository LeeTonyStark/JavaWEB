package com.lifeng.java.day18.demo;

import java.util.HashSet;

/**
 * @author lifeng
 * @create 2022-07-13 14:14
 */
public class demo5 {
    public static void main(String[] args) {
        HashSet<Integer> integers = new HashSet<>();
        integers.add(111);
        integers.add(222);
        integers.add(333);
        integers.add(333);
        for (Integer integer : integers) {
            System.out.println(integer);
        }

        HashSet<A> as = new HashSet<>();
        as.add(new A("佩奇",13));
        as.add(new A("乔治",14));
        as.add(new A("乔治妈妈",21));

        for (A a : as) {
            System.out.println(a);
        }
    }
}
