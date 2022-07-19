package com.lifeng.java.day22.exer;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/**
 7.分析以下需求，并用代码实现
 实现一个验证码小程序，要求如下：
 1. 在项目根目录下新建一个文件：data.txt,键盘录入3个字符串验证码，并存入data.txt中，要求一个验证码占一行；
 2. 键盘录入一个需要被校验的验证码，如果输入的验证码在data.txt中存在：在控制台提示验证成功，如果不存在控制台提示验证失败
 * @author lifeng
 * @create 2022-07-20 0:52
 */
public class exer7 {
    public static void main(String[] args) throws Exception{
        //1. 在项目根目录下新建一个文件：data.txt,键盘录入3个字符串验证码，并存入data.txt中，要求一个验证码占一行；
        Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("data.txt"));
        int count = 0;
        while (count < 3){
            System.out.println("请输入三串字符串验证码:");
            String next = scanner.next();
            if (next != null){
                bw.write(next + "\n"); //写入字符串
                bw.flush();
                count++;
            }
        }

        System.out.println("录入成功！");
        bw.close();//关流

        System.out.println("-----------------------------");
        System.out.println("请输入校验码");
        //2. 键盘录入一个需要被校验的验证码，如果输入的验证码在data.txt中存在：在控制台提示验证成功，如果不存在控制台提示验证失败
        String next1 = scanner.next();
        String s = "";
        while ((s = br.readLine()) != null){
            if (s.equals(next1)){
                System.out.println("校验成功！");
            }
        }

        br.close();//关流
        scanner.close();//关闭录入流

    }
}
