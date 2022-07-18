package com.lifeng.java.day19.demo;

/**
 * @author lifeng
 * @create 2022-07-14 15:09
 */
public class demo6 {
    public static void main(String[] args) {
        System.out.println(addNum(1, 2, 3));
    }

    public static int addNum(int...a){
        int q = 0;
        for (int i : a) {
            q += i;
        }
        return q;
    }
}
