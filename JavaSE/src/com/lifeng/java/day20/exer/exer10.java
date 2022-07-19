package com.lifeng.java.day20.exer;

import java.util.*;

/**
 * @author lifeng
 * @create 2022-07-16 14:24
 */
public class exer10 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a3");
        list.add("c10");
        list.add("p9");
        list.add("10");
        list.add("105");
        list.add("23");

        TreeMap<String,Integer> map = new TreeMap<>();

        for (String s : list) {
            map.put(s.substring(0,1),Integer.parseInt(s.substring(1)));
        }

        StringBuilder str = new StringBuilder();

        Set<Map.Entry<String, Integer>> set = map.entrySet();
        for (Map.Entry<String, Integer> entry : set) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            for (int i = 0; i < value; i++) {
                str.append(key);
            }
        }

        System.out.println(str);
    }
}
