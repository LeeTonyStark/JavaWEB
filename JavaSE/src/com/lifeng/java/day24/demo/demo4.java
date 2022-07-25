package com.lifeng.java.day24.demo;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author lifeng
 * @create 2022-07-21 11:43
 */
public class demo4 {
    public static void main(String[] args) throws Exception{
        //创建Properties容器
        Properties properties = new Properties();
        //加载database.properties配置文件
        properties.load(new FileInputStream("database.properties"));

        //解析(通过键找到对应的值)
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        System.out.println(username + "..." + password + "..." + driver);
    }
}
