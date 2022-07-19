package com.lifeng.java.day13.demo;

import java.math.BigDecimal;

/**
 * @author lifeng
 * @create 2022-07-06 16:52
 */
public class demo5 {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(12);
        System.out.println(bigDecimal);

        BigDecimal add = bigDecimal.add(BigDecimal.valueOf(11.2));
        System.out.println(add);
    }
}
