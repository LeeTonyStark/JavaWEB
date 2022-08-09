package com.lifeng.java.day33.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author lifeng
 * @create 2022-08-03 14:09
 */
public class demo3 {
    public static void main(String[] args) throws Exception{
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true", "root", "abc123");

        //获取执行sql语句对象
        Statement stat = conn.createStatement();

        //执行sql语句
        ResultSet resultSet = stat.executeQuery("select * from a");

        while (resultSet.next()){
//            int anInt = resultSet.getInt(1);
//            String string = resultSet.getString(2);
//            System.out.println(anInt + "..." + string);
            //推荐写的方式：
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println(id + ".." + name);
        }

        //关闭资源
        stat.close();
        conn.close();
    }
}
