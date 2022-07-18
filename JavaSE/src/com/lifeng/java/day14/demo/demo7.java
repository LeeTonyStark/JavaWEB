package com.lifeng.java.day14.demo;

import java.time.LocalDateTime;
import java.time.Month;

/**
 * @author lifeng
 * @create 2022-07-07 16:29
 */
public class demo7 {
    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
//        System.out.println(now);

//        LocalDateTime of = LocalDateTime.of(1999, 10, 10, 5, 6, 1);
//        System.out.println(of);
        int year = now.getYear();
        int month = now.getMonthValue();
        int dayOfMonth = now.getDayOfMonth();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();

        System.out.println(year+"年"+month+"月" +dayOfMonth + "日" +hour + "时" +minute+ "分" +second + "秒");


    }
}
