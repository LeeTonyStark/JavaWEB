package com.lifeng.java.day14.demo;

import java.time.LocalDateTime;

/**
 * @author lifeng
 * @create 2022-07-07 17:23
 */
public class demo9 {
    public static void main(String[] args) {

        //增加和减少年份
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = now.plusYears(1);
        System.out.println(localDateTime);

        //修改时间
        LocalDateTime localDateTime1 = localDateTime.withYear(2018);
        System.out.println(localDateTime1);

    }
}
