package com.lifeng.java.day10.demo;

/**
 * 递归方法的测试
 * @author lifeng
 * @create 2022-07-03 15:24
 */
public class demo3 {

    public static void main(String[] args) {

        //计算1-100之间所有自然数的和
        demo3 demo3 = new demo3();
        int sum = demo3.getSum(100);
        System.out.println(sum);
        //计算1-100乘积之和
        int sum1 = demo3.getSum1(10);
        System.out.println(sum1);

    }

    //计算1-n求和方法
    public int getSum(int n){
        if (n ==1){
            return 1;
        }else{
            return n + getSum(n - 1);
        }
    }

    //计算1-n求乘积方法
    public int getSum1(int n){
        if (n ==1){
            return 1;
        }else{
            return n * getSum1(n - 1);
        }
    }

}
