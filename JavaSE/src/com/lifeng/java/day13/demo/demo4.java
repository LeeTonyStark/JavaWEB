package com.lifeng.java.day13.demo;

import java.util.Date;

/**
 * @author lifeng
 * @create 2022-07-06 16:34
 */
public class demo4 {
    public static void main(String[] args) {

        System.out.println(new Date());//当前时间

        System.out.println(new Date(123L));//123毫秒的时间

        Date date = new Date();
        System.out.println("当前系统时间为" + date.getTime());

        date.setTime(5462145552L);
        System.out.println("设置的时间为：" + date.getTime());
    }
}
