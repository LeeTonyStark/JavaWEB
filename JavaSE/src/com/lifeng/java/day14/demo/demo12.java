package com.lifeng.java.day14.demo;

import java.math.BigDecimal;

/**
 * BigDecimal类的使用
 * @author lifeng
 * @create 2022-07-07 18:50
 */
public class demo12 {
    public static void main(String[] args) {
        //BigDecimal类的作用:可以使小数运算更加精准
        //常见的构造方法:常用String类型的构造器
        BigDecimal bigDecimal = new BigDecimal("55.54");
        System.out.println(bigDecimal);

        BigDecimal bigDecimal1 = new BigDecimal("35.5");
        BigDecimal add = bigDecimal.add(bigDecimal1);
        System.out.println(add);

        BigDecimal subtract = bigDecimal.subtract(bigDecimal1);
        System.out.println(subtract);

        System.out.println(bigDecimal.multiply(bigDecimal1));

        System.out.println(bigDecimal.divide(bigDecimal1, 2, BigDecimal.ROUND_HALF_UP));

    }
}
