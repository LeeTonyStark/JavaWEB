package com.lifeng.java.day33.demo;

import java.sql.*;
import java.util.Scanner;

/**
 * @author lifeng
 * @create 2022-08-03 16:15
 */
public class demo7 {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = scanner.nextLine();
        System.out.println("请输入密码：");
        String password = scanner.nextLine();
        if (login(username,password)){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }

    }

    private static boolean login(String username, String password) throws ClassNotFoundException, SQLException {
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true", "root", "abc123");
        //获取执行sql语句对象
        PreparedStatement ps = conn.prepareStatement("select * from user where username = ? and password = ?");
        //给?占位符赋值
        ps.setString(1,username);
        ps.setString(2,password);

        //执行sql语句
        ResultSet resultSet = ps.executeQuery();

        return resultSet.next();
    }
}
