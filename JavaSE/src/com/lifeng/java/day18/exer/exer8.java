package com.lifeng.java.day18.exer;

import java.util.*;

/**
 * 8.需求：给定一个数组：{"张柏芝","刘德华","张亮","张靓颖","杨颖","黄晓明"}
 * 	1、编写一个方法：将数组中的元素添加到list集合中，并把所有姓张的人员读取出来打印到控制台上。
 * 	2、对集合中的人员进行排序(主要条件:长度,次要条件:姓氏)倒叙,并保留重复的元素。
 * 	3、把排序好的元素，使用迭代器的方式打印出来。
 * @author lifeng
 * @create 2022-07-13 21:07
 */
public class exer8 {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("张柏芝");
        list.add("刘德华");
        list.add("张亮");
        list.add("张靓颖");
        list.add("杨颖");
        list.add("黄晓明");
        System.out.println("排序前："+list);
        System.out.println("所有姓张的：");
        for (String s : list) {
            if (s.startsWith("张")){
                System.out.println(s);
            }
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int len = o2.length() - o1.length();
                int name = len == 0 ? o2.compareTo(o1) : len;
                return name;
            }
        });

        System.out.println("排序后：" + list);
        for (String s : list) {
            System.out.println(s);
        }

    }
}
