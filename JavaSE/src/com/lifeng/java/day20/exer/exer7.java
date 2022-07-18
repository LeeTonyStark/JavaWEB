package com.lifeng.java.day20.exer;

/**
 * 递归练习：
 * 2.一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author lifeng
 * @create 2022-07-16 11:54
 */
public class exer7 {
    public static void main(String[] args) {
        System.out.println(jump(5));
    }

    public static int jump(int n){
        if (n<=1){
            return 1;
        }
        return jump(n-1) + jump(n-2);
    }
}
