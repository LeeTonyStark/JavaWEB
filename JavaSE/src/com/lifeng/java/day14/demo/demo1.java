package com.lifeng.java.day14.demo;

import java.util.Calendar;
import java.util.Date;

/**
 * @author lifeng
 * @create 2022-07-07 11:20
 */
public class demo1 {
    public static void main(String[] args) {

        //测试Calendar的方法
        Calendar calendar = Calendar.getInstance();//获取Calendar实例

        System.out.println(calendar.get(Calendar.YEAR));//获取年
        System.out.println(calendar.get(Calendar.MONTH) + 1);//月
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));//日

        calendar.set(Calendar.YEAR,1990);

        int year = calendar.get(Calendar.YEAR);
        System.out.println(year);
        calendar.set(Calendar.MONTH,7);
        System.out.println(calendar.get(Calendar.MONTH));

        Date time = calendar.getTime();
        System.out.println(time);

        calendar.add(Calendar.YEAR,10);
        calendar.add(Calendar.DAY_OF_MONTH,8);
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

    }
}
