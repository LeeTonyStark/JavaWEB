package com.lifeng.java.day33.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 测试JDBC数据库连接
 * @author lifeng
 * @create 2022-08-03 9:42
 */
public class demo1 {
    public static void main(String[] args) throws Exception{
        //1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取数据库连接对象
        // "jdbc:mysql://localhost:3306/" + 数据库名称 + "?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true"
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true", "root", "abc123");
        //3.获取执行sql语句对象
        Statement stat = conn.createStatement();
        //4.执行sql语句
        int i = stat.executeUpdate("insert  into b values(5,'老王')");
        System.out.println(i);
        //5.释放资源
        stat.close();
        conn.close();
    }
}
