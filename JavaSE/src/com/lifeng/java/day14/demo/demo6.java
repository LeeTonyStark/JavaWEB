package com.lifeng.java.day14.demo;

import java.math.BigDecimal;

/**
 * @author lifeng
 * @create 2022-07-07 15:49
 */
public class demo6 {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("10");
        BigDecimal bigDecima2 = new BigDecimal("3");
        BigDecimal result = bigDecimal.divide(bigDecima2, 2, BigDecimal.ROUND_DOWN);
        System.out.println(result);
        BigDecimal result1 = bigDecimal.divide(bigDecima2, 2, BigDecimal.ROUND_UP);
        System.out.println(result1);
        BigDecimal result2 = bigDecimal.divide(bigDecima2, 2, BigDecimal.ROUND_HALF_UP);
        System.out.println(result2);


    }
}
