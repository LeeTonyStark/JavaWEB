package com.lifeng.java.day17.demo;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author lifeng
 * @create 2022-07-12 15:29
 */
public class demo5 {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<String>();
        treeSet.add("ccc");
        treeSet.add("ddd");
        treeSet.add("aaa");
        treeSet.add("eee");

        for (String s : treeSet) {
            System.out.println(s);
        }

        Object[] objects = treeSet.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }

        Iterator<String> iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
