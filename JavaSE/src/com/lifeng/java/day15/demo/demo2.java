package com.lifeng.java.day15.demo;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lifeng
 * @create 2022-07-08 11:06
 */
public class demo2 {
    public static void main(String[] args) throws Exception{

        FileInputStream fileInputStream = new FileInputStream("aaa");

        try{
            System.out.println("程序开始(运行时)");
            int i = 10;
//            i = i / 0;
            i += 1;
            System.out.println("运行中");

            System.out.println("程序开始(编译)");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = simpleDateFormat.parse("2020/01/01");
            System.out.println("程序执行中");
        }catch (Exception e){
            System.out.println("执行了运行时异常");
        }



        System.out.println("**************************");



        try {
            System.out.println("程序开始");
            int i = 20;
            i += 1;
            System.out.println("没有异常");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("执行了异常");
        }

        System.out.println("程序结束");

        System.out.println("**************************");


        try {
            System.out.println("程序开始");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = simpleDateFormat.parse("2020-01-01");
            System.out.println("程序执行中");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("执行了异常");
        }

        System.out.println("程序结束");

        System.out.println("**************************");


        try {
            System.out.println("程序开始");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = simpleDateFormat.parse("2020、01、01");
            System.out.println("程序执行中");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("执行了异常");
        }

        System.out.println("程序结束");



    }
}
