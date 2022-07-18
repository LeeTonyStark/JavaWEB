package com.lifeng.java.day18.demo;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author lifeng
 * @create 2022-07-13 14:07
 */
public class demo4 {
    public static void main(String[] args) {
        HashSet<String> strings = new HashSet<>();
        strings.add("aaa");
        strings.add("bbb");
        strings.add("ccc");
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for (String string : strings) {
            System.out.println(string);
        }

        Object[] objects = strings.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }
    }
}
