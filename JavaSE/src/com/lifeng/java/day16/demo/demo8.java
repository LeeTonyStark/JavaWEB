package com.lifeng.java.day16.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lifeng
 * @create 2022-07-11 14:37
 */
public class demo8 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("aaaa");
        list.add("fffff");
        list.add("1123dd");

        //增
        list.add(0,"OPQR");
        System.out.println(list);
        //删
        list.remove(1);
        System.out.println(list);
        //改
        list.set(2,"ssssssss");
        System.out.println(list);
        //查
        list.get(2);
        System.out.println(list);
    }
}
