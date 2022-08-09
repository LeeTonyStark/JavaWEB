package com.lifeng.java.day33.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author lifeng
 * @create 2022-08-03 14:29
 */
public class demo4 {
    public static void main(String[] args) throws Exception{
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true", "root", "abc123");

        //获取执行sql语句对象
        Statement stat = conn.createStatement();

        //执行sql语句
//        boolean execute = stat.execute("insert into a values(5,'peiqi')");
//        boolean execute = stat.execute("update a set name = 'timi' where name = 'peiqi'");
        boolean execute = stat.execute("select * from a");
        System.out.println(execute);

        //关闭资源
        stat.close();
        conn.close();
    }
}
