package com.lifeng.java.day16.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author lifeng
 * @create 2022-07-09 11:27
 */
public class demo4 {
    public static void main(String[] args) {
        //练习：已知集合中存储了几个元素:"aaa","bbb","aaa","ccc","aaa","ddd"
        //要求把集合中的所有"aaa"删除
        List list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("aaa");
        list.add("ccc");
        list.add("aaa");
        list.add("ddd");

        System.out.println("移除前：" + list);

        list.removeIf(new Predicate() {
            @Override
            public boolean test(Object o) {
                return o.equals("aaa");
            }
        });

        System.out.println("移除后"+list);
    }
}
