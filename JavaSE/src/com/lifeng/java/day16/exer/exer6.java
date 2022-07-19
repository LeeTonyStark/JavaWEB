package com.lifeng.java.day16.exer;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * @author lifeng
 * @create 2022-07-11 11:19
 */
public class exer6 {
    public static void main(String[] args) {
        //删除长度大于3的字符串

        ArrayList<String> strings = new ArrayList<>();
        strings.add("abnkh");
        strings.add("ws");
        strings.add("ws2");
        strings.add("ws2e");
        strings.add("2e");
        strings.add("12e");

        System.out.println(strings);

        strings.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {

                return s.length() > 3;
            }
        });

        System.out.println(strings);
        System.out.println("**********************");

        ArrayList<Object> integers = new ArrayList<>();
        integers.add(87);
        integers.add("fhkjfhkjsks");
        integers.add("s1w");
        integers.add("s1ojdsdsd");
        integers.add(12334);

        integers.removeIf(new Predicate<Object>() {
            @Override
            public boolean test(Object o) {
                return o instanceof Integer;
            }
        });

        System.out.println(integers);

    }
}
