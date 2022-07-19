package com.lifeng.java.day14.demo;

import java.math.BigDecimal;

/**
 * @author lifeng
 * @create 2022-07-07 15:24
 */
public class demo5 {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("33.3");
        BigDecimal bigDecimal1 = new BigDecimal(33.3);
        BigDecimal bigDecimal2 = new BigDecimal(33);
        System.out.println(bigDecimal);
        System.out.println(bigDecimal1);
        System.out.println(bigDecimal2);
        System.out.println("****************");
        BigDecimal bigDecimal3 = new BigDecimal("33.3");
        BigDecimal bigDecimal4 = new BigDecimal("12.8");

        System.out.println(bigDecimal3.add(bigDecimal4));

        System.out.println(bigDecimal3.subtract(bigDecimal4));

        System.out.println(bigDecimal3.multiply(bigDecimal4));

        System.out.println(bigDecimal3.divide(bigDecimal4));

//        BigDecimal bigDecimal5 = new BigDecimal(10);
//        BigDecimal bigDecimal6 = new BigDecimal(3);
//        System.out.println(bigDecimal5.divide(bigDecimal6));

    }
}
