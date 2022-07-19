package com.lifeng.java.day16.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author lifeng
 * @create 2022-07-11 14:45
 */
public class demo9 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("aaaaaa");
        list.add("addgdg");
        list.add("aadgdg");
        list.add("aaagdggdgd");
        list.add("a1212323");

        //1.增强for
        for (Object o : list) {
            System.out.println(o);
        }
        //2.转数组
        Object[] objects = list.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }
        //3.迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }
        //4.普通for
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
