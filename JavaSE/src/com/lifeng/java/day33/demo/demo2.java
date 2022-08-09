package com.lifeng.java.day33.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author lifeng
 * @create 2022-08-03 11:40
 */
public class demo2 {
    public static void main(String[] args) throws Exception{
        //注册驱动
        Class.forName("com.mysql.cj.Driver");

        //获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?username=root,password=abc123,characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true");
        Statement stat = conn.createStatement();
        ResultSet resultSet = stat.executeQuery("select * from a");
        System.out.println(resultSet);
    }
}
