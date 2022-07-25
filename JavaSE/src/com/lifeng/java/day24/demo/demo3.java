package com.lifeng.java.day24.demo;

import java.util.Properties;
import java.util.Set;

/**
 * @author lifeng
 * @create 2022-07-21 11:13
 */
public class demo3 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("asadda","1212121");
        properties.setProperty("asadda221","1212121");
        properties.setProperty("asadda44","1212121");
        properties.setProperty("asadda2","1212121");
        properties.setProperty("asadda1134","1212121");
        Set<String> set = properties.stringPropertyNames();
        for (String s : set) {
            String value = properties.getProperty(s);
            System.out.println(s + "::" + value);
        }
    }
}
