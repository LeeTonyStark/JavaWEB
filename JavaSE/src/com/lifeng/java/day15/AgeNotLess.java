package com.lifeng.java.day15;

/**
 * @author lifeng
 * @create 2022-07-08 14:45
 */
public class AgeNotLess extends RuntimeException{
    public AgeNotLess(){}
    public AgeNotLess(String s){
        System.out.println("年龄太小");
    }
}
