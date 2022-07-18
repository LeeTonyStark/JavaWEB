package com.lifeng.java.day14.exer;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

/**
 * @author lifeng
 * @create 2022-07-07 11:40
 */
public class exer1{
    public static void main(String[] args) {
        //输入一个年份，判断是平年还是闰年，平年的2月份是28天，闰年的二月是29天
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,2);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.add(Calendar.DAY_OF_MONTH,-1);
        if (calendar.get(Calendar.DAY_OF_MONTH) == 29){
            System.out.println("是闰年");
        }else {
            System.out.println("是平年");
        }
    }
}
