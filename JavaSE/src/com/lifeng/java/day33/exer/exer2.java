package com.lifeng.java.day33.exer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 2. 定义一张user表，字段为id，username，password， 使用JDBC对表中的数据进行增删改查操作。
 * 注意：要求JDBC步骤必须完整。(10分)
 * @author lifeng
 * @create 2022-08-08 18:50
 */
public class exer2 {
    public static void main(String[] args) throws Exception{
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true", "root", "abc123");
        //获取执行sql语句对象
//        //增------------------------------------
//        PreparedStatement ps = conn.prepareStatement("insert into user values (null,?,?)");
//        //给?占位符赋值
//        ps.setString(1,"test1");
//        ps.setString(2,"test1");
//        //改--------------------------------------
//        PreparedStatement ps = conn.prepareStatement("update user set `username` = ?,`password` = ? where id = ?");
//        //给?占位符赋值
//        ps.setString(1,"test2");
//        ps.setString(2,"test2");
//        ps.setString(3,"4");
//        //删--------------------------------------
//        PreparedStatement ps = conn.prepareStatement("delete from user where id = ?");
//        //给?占位符赋值
//        ps.setString(1,"4");
        //查询--------------------------------------
        PreparedStatement ps = conn.prepareStatement("select * from `user` where id = ?");
        //给?占位符赋值
        ps.setString(1,"3");
        //执行sql语句
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString("username"));
        }
    }
}
