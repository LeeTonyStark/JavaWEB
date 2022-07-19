package com.lifeng.java.day14.demo;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 1.8新增日期时间类 LocalDateTime、LocalDate、LocalTime
 * @author lifeng
 * @create 2022-07-07 19:01
 */
public class demo13 {
    public static void main(String[] args) throws ParseException {
        //1.常用的成员方法
//        LocalDateTime now = LocalDateTime.now();//now()获取当前时间
//        System.out.println(now);
//
//        //of():设置日期时间
//        LocalDateTime of = LocalDateTime.of(1840, 9, 18, 8, 8, 8);
//        System.out.println(of);
//
//        //getYear():获取年
//        int year = now.getYear();
//        System.out.println(year);
//
//        System.out.println(now.getHour());
//
//        System.out.println(now.getMonthValue());
//
//        System.out.println(now.getDayOfMonth());
//
//        System.out.println(now.getMinute());
//
//        System.out.println(now.getSecond());
//
//        LocalTime localTime = now.toLocalTime();
//        System.out.println(localTime);
//
//        System.out.println(now.toLocalDate());
//
//        //格式化：
//        //1.先创建一个DateTimeFormatter的实例调用ofPattern()方法，ofPattern方法里面
//        //写上日期的格式
//        //将Date转换成String
//
//        System.out.println("格式化之前："+now);
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        String format = now.format(dateTimeFormatter);
//        System.out.println(format);
//
//        //解析：
//        /*
//        1.先创建DateTimeFormatter的实例调用ofPattern()方法,方法中设置String日期的格式
//        2.用一个String字符串存储时间
//        3.使用LocalDateTime.parse(日期,DateTimeFormatter的实例对象)解析得到LocalDateTime类型的数据
//         */
//        String s = "1840-03-08 08:08:08";
//        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime parse = LocalDateTime.parse(s, dateTimeFormatter1);
//        System.out.println("解析后的日期为：" + parse);
//
//        //增加和减少时间 pulsYears()
//        LocalDateTime localDateTime = parse.plusYears(1);//增加一年
//        System.out.println(localDateTime);
//
//        //修改时间：withYear
//        System.out.println(parse.withYear(1995));

        //练习：已知String s = "2022-07-07",要求将天数增加1天，变成String s = "2022-07-08"
        //方法一：使用jdk1.8新增的LocalDateTime通过解析时间来做
        String s1 = "2022-07-07";
        //先解析为LocalDate格式数据
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parse1 = LocalDate.parse(s1,dateTimeFormatter2);
        System.out.println("练习题解析后"+parse1);

        LocalDate localDate = parse1.plusDays(1);
        String format = localDate.format(dateTimeFormatter2);
        System.out.println(format);

        //方式二：通过Date类来做
        String s2 = "2022-07-07";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = simpleDateFormat.parse(s2);
        System.out.println(parse);



    }
}
