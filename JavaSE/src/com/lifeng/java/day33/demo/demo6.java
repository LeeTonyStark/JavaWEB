package com.lifeng.java.day33.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author lifeng
 * @create 2022-08-03 15:06
 */
public class demo6 {
    public static void main(String[] args) throws Exception{
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true", "root", "abc123");
        //获取执行sql语句对象
        Statement stat = conn.createStatement();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名和密码(格式:用户名,密码)");

        //执行sql语句
        ResultSet resultSet = stat.executeQuery("select * from user");
        ArrayList<User> users = new ArrayList<>();

        while (resultSet.next()){
            String name = resultSet.getString("username");
            String password = resultSet.getString("password");
            users.add(new User(name,password));
        }

        String next = scanner.next();
        String[] split = next.split(",");

        for (User user : users) {
            if (user.getUsername().equals(null) || user.getPassword().equals(null)){
                System.out.println("账户名或密码不能那个为空");
            }
            if (user.getUsername().equals(split[0]) && user.getPassword().equals(split[1])){
                System.out.println("登录成功");
            }
            if (!(user.getUsername().equals(split[0]) && user.getPassword().equals(split[1]))){
                System.out.println("用户名或密码错误，登录失败");
            }
        }

        stat.close();
        resultSet.close();
        conn.close();

    }
}

class User{
    private int id;
    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
