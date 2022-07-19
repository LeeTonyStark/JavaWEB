package com.lifeng.java.day18.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author lifeng
 * @create 2022-07-13 17:23
 */
public class demo12 {
    public static void main(String[] args) {
        HashMap<String, Integer> sim = new HashMap<>();
        sim.put("aaa",11);
        sim.put("bbb",21);
        sim.put("ccc",31);
        sim.put("ddd",11);
        sim.put("eee",81);
        sim.put("fff",61);
        sim.put("ggg",21);

        Set<Map.Entry<String, Integer>> entries = sim.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + "..." + value);
        }
    }
}
