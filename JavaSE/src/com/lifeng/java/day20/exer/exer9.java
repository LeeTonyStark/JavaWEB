package com.lifeng.java.day20.exer;

import java.util.*;

/**
 * @author lifeng
 * @create 2022-07-16 14:18
 */
public class exer9 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("c");
        list.add("e");
        list.add("e");
        list.add("c");
        list.add("e");
        list.add("b");
        list.add("b");
        list.add("b");
        list.add("c");

        //使用HashSet去重
        HashSet<String> set = new HashSet<>();
        set.addAll(list);

        list.clear();

        list.addAll(set);

        Collections.sort(list);
        System.out.println(list);
    }
}
