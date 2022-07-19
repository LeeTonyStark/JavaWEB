package com.lifeng.java.day18.exer;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Locale;
import java.util.TreeSet;

/**
 * 5.从键盘接收一个字符串, 程序对其中所有字符进行排序,例如键盘输入: helloworld,程序打印:dehllloorw
 * @author lifeng
 * @create 2022-07-13 21:21
 */
public class exer9 {
    public static void main(String[] args) {
        String s = "HelloWorld";
        String[] split = s.split("");
        TreeSet<String> objects = new TreeSet<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i = o1.toLowerCase(Locale.ROOT).compareTo(o2.toLowerCase(Locale.ROOT));
                int i1 = i == 0 ? 1 : o1.toLowerCase(Locale.ROOT).compareTo(o2.toLowerCase(Locale.ROOT));
                return i1;
            }
        });
        for (int i = 0; i < split.length; i++) {
            objects.add(split[i]);
        }

        for (String object : objects) {
            System.out.println(object);
        }
    }
}
