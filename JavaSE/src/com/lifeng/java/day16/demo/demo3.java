package com.lifeng.java.day16.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lifeng
 * @create 2022-07-09 11:09
 */
public class demo3 {
    public static void main(String[] args) {
        //add(int xxx,Object xxx):在指定索引位置添加元素
        List list = new ArrayList();
        list.add("546");
        list.add(1111);
        list.add(1232323);

        System.out.println(list);

        list.add(2,"888");
        System.out.println(list);

        //get():获取指定索引位置的元素
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(3));

        //remove():删除指定索引元素或指定元素
        list.remove(1);
        System.out.println(list);

        //set():修改指定索引，返回的是被修改的数据
        Object set = list.set(1, "999");
        System.out.println("修改：" + set);

    }
}
