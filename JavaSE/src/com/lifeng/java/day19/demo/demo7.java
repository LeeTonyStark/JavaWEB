package com.lifeng.java.day19.demo;

/**
 * @author lifeng
 * @create 2022-07-14 15:34
 */
public class demo7 {
    public static void main(String[] args) {
        //求N的阶乘，使用递归
        System.out.println(jieCheng(5));
    }

    public static int jieCheng(int n){
        if (n == 1){
            return 1;
        }
        int i = n * jieCheng(n-1);

        return i;
    }
}
