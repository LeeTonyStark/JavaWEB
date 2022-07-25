package com.lifeng.java.day24.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author lifeng
 * @create 2022-07-21 15:48
 */
public class demo6 {
    public static void main(String[] args) throws IOException {
//        Class clazz = Person.class;
//        ClassLoader classLoader = clazz.getClassLoader();
//        InputStream resourceAsStream = classLoader.getResourceAsStream("aaa.properties");
//
//        Properties properties = new Properties();
//        //加载配置文件
//        properties.load(resourceAsStream);
//
//        String username = properties.getProperty("username");
//        String password = properties.getProperty("password");
//        System.out.println(username + "=" + password);

        //优化：

        Properties properties = new Properties();
        properties.load(Person.class.getClassLoader().getResourceAsStream("aaa.properties"));
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        System.out.println(username + "=" + password);

    }
}
