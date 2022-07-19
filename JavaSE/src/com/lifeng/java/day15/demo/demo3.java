package com.lifeng.java.day15.demo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author lifeng
 * @create 2022-07-08 11:48
 */
public class demo3 {
    public static void main(String[] args) {

//                String str = "123";
//                System.out.println(str + 10); //"12310"
//                int i = Integer.parseInt(str);//123100
//                System.out.println(i + 10);//133

//        LocalDate now = LocalDate.now();
//        int month = now.getMonthValue();
//        System.out.println(month);
//        String s = new String("abcdefg"); for (int i=0; i<s.length(); i+=2){ System.out.print(s.charAt(i)); }

        //设计方法，对字符串”abc-edf-xyz“进行拆分，拆分后每段首字符变为大写
//        String s = "abc-edf-xyz";
//        String s1 = "";
//        String[] split = s.split("-");
//        for (int i = 0; i < 3; i++) {
//            s1 += split[i].substring(0,1).toUpperCase() + split[i].substring(1);
//        }
//        System.out.println(s1);

        String time = "2021-01-01";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(time,dateTimeFormatter);
        LocalDate localDate1 = localDate.plusDays(1);
        String s = localDate1.format(dateTimeFormatter);
        System.out.println(s);
    }
}
