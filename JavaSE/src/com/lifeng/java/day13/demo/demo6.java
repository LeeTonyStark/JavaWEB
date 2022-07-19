package com.lifeng.java.day13.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lifeng
 * @create 2022-07-06 17:06
 */
public class demo6 {
    public static void main(String[] args) throws ParseException {
        //日期的格式化
//        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
////        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E");
//        String format = simpleDateFormat.format(date);
//        System.out.println(format);

        //解析
        String s = "1998-02-24";
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = simpleDateFormat1.parse(s);

        long time = parse.getTime();

        Date date = new Date();
        long time1 = date.getTime();
        long liveTime = time1 - time;
        System.out.println("距您出生日期已有"+(liveTime/1000/60/60/24)+"天。");



    }
}
