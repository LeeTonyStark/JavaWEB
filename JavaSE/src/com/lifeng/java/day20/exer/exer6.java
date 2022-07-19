package com.lifeng.java.day20.exer;

/**
 * 递归练习
 * 1.斐波那契数列
 * @author lifeng
 * @create 2022-07-16 11:50
 */
public class exer6 {
    public static void main(String[] args) {
        //斐波那契数列的是这样一个数列：1、1、2、3、5、8、13、21、34…
        //那么第n项就是(n-2) + (n-1)
        System.out.println(fbnq(8));
    }

    //求斐波那契数列第n项的值
    public static int fbnq(int n){
        if (n<=2){
            return 1;
        }
        return fbnq(n-2) + fbnq(n-1);
    }
}
