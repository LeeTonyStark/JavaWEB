package com.lifeng.java.day14.demo;

import java.util.Calendar;

/**
 * Calendar类的测试
 * @author lifeng
 * @create 2022-07-07 17:34
 */
public class demo10 {
    public static void main(String[] args) {

        //Calendar类是一个抽象类，它代表一组如年月日等日期，并为它们转换提供了相关方法
        //成员方法：
        //public static Calendar getInstance():
        Calendar instance = Calendar.getInstance();
        int i1 = instance.get(Calendar.YEAR);
        int i2 = instance.get(Calendar.MONTH);
        int i3 = instance.get(Calendar.DAY_OF_MONTH);
        System.out.println(i1+"年" +i2 + "月" + i3);

        instance.set(2022,2,2);
        System.out.println(instance.get(Calendar.YEAR) + "年" + instance.get(Calendar.MONTH));
        int i = instance.get(Calendar.YEAR);
        instance.add(Calendar.YEAR,1);
        System.out.println(instance.get(Calendar.YEAR));

    }
}
