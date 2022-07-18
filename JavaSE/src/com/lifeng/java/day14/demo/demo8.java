package com.lifeng.java.day14.demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author lifeng
 * @create 2022-07-07 16:53
 */
public class demo8 {
    public static void main(String[] args) {

        String s = "2020-02-02 02:20:02";

        //解析
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(s, dateTimeFormatter);
        System.out.println(parse);

        //格式化
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");



    }
}
