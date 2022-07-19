package com.lifeng.java.day19.demo;

import java.util.*;

/**
 * @author lifeng
 * @create 2022-07-14 11:44
 */
public class demo3 {
    public static void main(String[] args) {
        TreeMap<String,Person> treeMap = new TreeMap<>();

        treeMap.put("aaa",new Person("佩奇",12));
        treeMap.put("bbb",new Person("乔治",13));
        treeMap.put("ccc",new Person("乔治妈妈",22));
        treeMap.put("ccc",new Person("乔治妈妈",21));

        Collection collection = treeMap.keySet();
        for (Object key : collection) {
            Person value = treeMap.get(key);
            System.out.println(key + "..." + value);
        }

        Set<Map.Entry<String, Person>> entries = treeMap.entrySet();
        for (Map.Entry<String, Person> entry : entries) {
            String string = entry.getKey();
            Person value = entry.getValue();
            System.out.println(string + "..." + value);
        }


    }
}
