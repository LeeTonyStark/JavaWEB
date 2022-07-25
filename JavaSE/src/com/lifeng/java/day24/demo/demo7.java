package com.lifeng.java.day24.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;

/**
 * @author lifeng
 * @create 2022-07-21 16:28
 */
public class demo7 {
    public static void main(String[] args) throws IOException {
        //D:\Work_space\workspace_idea1\JavaSE\src\aaa.properties
//        Class<Person> clazz = Person.class;
//        ClassLoader classLoader = clazz.getClassLoader();
//        URL url = classLoader.getResource("aaa.properties");
//        String path = url.getPath();//获得全路径
//        Properties properties = new Properties();
//        FileInputStream fis = new FileInputStream(path);
//        properties.load(fis);//读取配置文件
//        String username = properties.getProperty("username");
//        String password = properties.getProperty("password");
//        System.out.println(username + ":" + password);

        Properties p = new Properties();
        p.load(new FileInputStream(demo7.class.getClassLoader().getResource("aaa.properties").getPath()));
        String username = p.getProperty("username");
        String password = p.getProperty("password");
        System.out.println(username + "\t" + password);
    }
}
