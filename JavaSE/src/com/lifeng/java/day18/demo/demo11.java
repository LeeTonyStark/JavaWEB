package com.lifeng.java.day18.demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 * Map常用方法练习
 * @author lifeng
 * @create 2022-07-13 17:04
 */
public class demo11 {
    public static void main(String[] args) {
        HashMap<String, Integer> sim = new HashMap<>();
        sim.put("aaa",11);
        sim.put("bbb",21);
        sim.put("ccc",31);
        sim.put("ddd",11);
        sim.put("eee",81);
        sim.put("fff",61);
        sim.put("ggg",21);

//        sim.remove("bbb");//通过bbb键删除对应的键值对
//
//        System.out.println(sim);
//        System.out.println(sim.get("eee"));
//
//        System.out.println(sim);
//        System.out.println("containsKey判断是否包含某个键");
//        System.out.println(sim.containsKey("fff"));
//
//        System.out.println("contains判断是否包含某个值");
//        System.out.println(sim.containsValue(61));
//
//        System.out.println("values获取所有的值并放到Collection集合中");
//        Collection<Integer> values = sim.values();
//        for (Integer value : values) {
//            System.out.println(value);
//        }
//
//        System.out.println("keySet获取所有的键并放到Set集合中");
//        Set<String> set = sim.keySet();
//        for (String s : set) {
//            System.out.println(s);
//        }

        System.out.println("方式一：通过键找值");

        //先获取到map集合中所有的键
        Set<String> set = sim.keySet();
        for (String key : set) {
            //将通过get()获取值
            Integer value = sim.get(key);
            System.out.println(key + "..." + value);
        }

    }
}
