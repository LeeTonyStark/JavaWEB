package com.lifeng.java.day19.demo;

/**
 * @author lifeng
 * @create 2022-07-14 16:18
 */
public class demo8 {
    public static void main(String[] args) {
        System.out.println(fblq(6));
    }
    //求第N项斐波那契数列的值
    public static int fblq(int n){
        //出口
        if (n==1 || n==2){
            return 1;
        }
        return fblq(n-1) + fblq(n-2);
    }
}
