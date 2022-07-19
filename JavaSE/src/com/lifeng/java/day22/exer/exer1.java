package com.lifeng.java.day22.exer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 1.请用户从控制台输入信息，程序将信息存储到文件Info.txt中。可以输入多条信息，
 * 每条信息存储一行。当用户输入：”886”时，程序结束。
 * @author lifeng
 * @create 2022-07-19 18:55
 */
public class exer1 {
    public static void main(String[] args) {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);

        while(flag){
            System.out.println("请输入一个字符串：(输入886结束)");
            String next = scanner.next();//接收用户输入的字符串

            if (next.equals("886")){
                System.out.println("程序结束");
                flag = false;
            }

            Writer writer = null;
            try {
                writer = new FileWriter("Info.txt",true);
                writer.write(next + "\r\n");
            }catch (Exception e){
                System.out.println("写入发生了异常");
            }finally {
                if (writer != null){
                    try {
                        writer.flush();
                    }catch (Exception e){
                        System.out.println("刷新发生了异常");
                    }
                }
                if (writer != null){
                    try{
                        writer.close();
                    }catch (Exception e){
                        System.out.println("流关闭发生了异常");
                    }
                }

            }
        }
    }
}
