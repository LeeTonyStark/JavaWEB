package com.lifeng.java.day17.demo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author lifeng
 * @create 2022-07-12 15:18
 */
public class demo4 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");

        System.out.println("方式一增强for遍历");
        for (String s : set) {
            System.out.println(s);
        }

        System.out.println("方式二迭代器遍历");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("方式三转数组遍历");
        Object[] objects = set.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }

    }
}
