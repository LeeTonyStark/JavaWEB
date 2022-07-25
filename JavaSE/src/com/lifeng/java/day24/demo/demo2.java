package com.lifeng.java.day24.demo;

import java.util.Properties;
import java.util.Set;

/**
 * @author lifeng
 * @create 2022-07-21 10:53
 */
public class demo2 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("啦",5456);
        properties.put("啦121啦啦",5456);
        properties.put("啦啦3啦",5456);
        properties.put("啦啦2121啦",5456);

        Set<Object> set = properties.keySet();
        for (Object o : set) {
            Object value = properties.get(o);
            System.out.println(o + "::" + value);
        }

    }
}
