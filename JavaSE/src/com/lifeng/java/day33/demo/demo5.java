package com.lifeng.java.day33.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author lifeng
 * @create 2022-08-03 15:06
 */
public class demo5 {
    public static void main(String[] args) throws Exception{
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true", "root", "abc123");
        //获取执行sql语句对象
        Statement stat = conn.createStatement();
        //执行sql语句
        ResultSet resultSet = stat.executeQuery("select * from a");
        ArrayList<User> users = new ArrayList<>();
//        while (resultSet.next()){
//            int id = resultSet.getInt("id");
//            String name = resultSet.getString("name");
//            users.add(new User(id,name));
//        }
//
//        for (User user : users) {
//            System.out.println("ID=" + user.getId() + "," + "Name=" +  user.getName());
//        }

    }
}
