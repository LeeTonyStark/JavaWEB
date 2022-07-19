package com.lifeng.java.day22.exer;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 4.分析以下需求，并用代码实现
 1.项目根目录下建立文件： user.txt，文件中存放用户名和登录密码，格式：用户名，密码,如：aaa,123；
 2. user.txt文件中初始存放的用户信息有如下：
 jack,123
 rose,123
 tom,123
 3.要求完成如下功能：
 程序运行时：控制台提示用户输入注册的用户名和密码；
 验证键盘录入的用户名跟user.txt中已注册的用户名是否重复：
 是：控制台提示：用户名已存在
 否：将键盘录入的用户名及密码写入user.txt文件，并在控制台提示：注册成功；
 * @author lifeng
 * @create 2022-07-19 21:52
 */
public class exer4 {
    public static void main(String[] args) throws Exception{

        /*
        定义一个变量，ture表示用户名不存在，可以继续继续执行操作，
                    false表示用户名存在，不再执行其他操作。
         */
        boolean flag = true;

        //定义一个HashMap来存储用户名和密码
        HashMap<String, String> map = new HashMap<>();

        File file1 = new File("user.txt");
        File file2 = new File("user1.txt");

        Scanner scan = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = scan.next();//接收用户输入的账号
        System.out.println("请输入密码：");
        String password = scan.next();//接收用户输入的密码

        //取出user.txt文件中的用户名和密码
        BufferedReader fs = new BufferedReader(new FileReader(file1));

        String s = "";

        while ((s = fs.readLine()) != null){

            String[] split = s.split(",");
            //读取user.txt,将他存在map集合中
            map.put(split[0],split[1]);

            if (split[0].equals(username) && split[1].equals(password)){
                System.out.println("用户名已存在");
                flag = false;
                break;//跳出循环
            }else {
                //如果不重复，就将这个用户数据添加到map集合中
                map.put(username,password);
            }
        }

        if (flag){
            //将map中的数据全部写入到一个副本文件
            BufferedWriter bw = new BufferedWriter(new FileWriter(file2));//副本文件对象
            Set<Map.Entry<String, String>> entries = map.entrySet();
            for (Map.Entry<String, String> entry : entries) {
                String uname = entry.getKey();
                String pword = entry.getValue();
                bw.write(uname + "," + pword + "\n");//将map集合中的元素写入到副本文件
                bw.flush();
            }

            bw.close();//关流

            //将副本文件复制给user.txt
            BufferedReader br1 = new BufferedReader(new FileReader(file2));
            BufferedWriter bw1 = new BufferedWriter(new FileWriter(file1));

            String s1 = "";
            while ((s1 = br1.readLine()) != null){
                bw1.write(s1 + "\n");
                bw1.flush();//刷新
            }
            System.out.println("注册成功");
            //关流
            br1.close();
            bw1.close();

        }

            fs.close();//关流


    }
}
