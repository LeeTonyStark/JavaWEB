package com.lifeng.java.day12.exer;

import java.util.Scanner;

/**
 * @author lifeng
 * @create 2022-07-05 17:46
 */
public class exer2 {
    private String username = "admin";//账号
    private String password = "abc123";//密码

    private int Count = 0;//记录用户错误次数

    public static void main(String[] args) {
        exer2 exer2 = new exer2();
        exer2.login(exer2.username, exer2.password);
    }

    public void login(String username,String password){

            Scanner scan = new Scanner(System.in);

        while (Count < 3){

            System.out.println(("请输入用户名："));
            String getUsername = scan.next();
            System.out.println(("请输入密码："));
            String getPassword = scan.next();

                //判空
                if (username.equals(null) || password.equals(null)){
                    System.out.println("用户名或密码不能为空");
                    return;
                }

                if (!(username.equals(getUsername) && password.equals(getPassword))) {
                    System.out.println("账户名和密码错误");

                }else {
                    System.out.println(("登陆成功"));
                    scan.close();//关闭Scanner流
                    return;
                }
                Count++;

        }

        System.out.println(Count);
            if (Count >= 3) {
                System.out.println("您已输入错误三次，关闭系统");
                scan.close();
                return;
            }
    }
}
