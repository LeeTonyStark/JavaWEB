package com.lifeng.java.day17.demo;

import java.util.ArrayList;

/**
 * @author lifeng
 * @create 2022-07-12 14:45
 */
public class demo3 {
    public static void main(String[] args) {
        ArrayList<?> s1 = new ArrayList<String>();
        ArrayList<?> s2 = new ArrayList<Integer>();
        ArrayList<?> s3 = new ArrayList<Character>();
//        s1.add("aas");


        //？ extends E:左边是问号继承，右边就必须是它自身或者它的子类
        ArrayList<? extends Number> s4 = new ArrayList<Number>();
        ArrayList<? extends Number> s5 = new ArrayList<Integer>();
        ArrayList<? extends Number> s6 = new ArrayList<Double>();
//        ArrayList<? extends Number> s7 = new ArrayList<String>();
//        ArrayList<? extends Number> s8 = new ArrayList<Object>();
//        s4.add(111);
//        s5.add(111);

        //? super E:左边是？super，右边就必须是它自身或者它的父类
        ArrayList<? super Number> n1 = new ArrayList<Number>();
//        ArrayList<? super Number> n2 = new ArrayList<Integer>();
//        ArrayList<? super Number> n3 = new ArrayList<Double>();
//        ArrayList<? super Number> n4 = new ArrayList<String>();
        ArrayList<? super Number> n5 = new ArrayList<Object>();
        n1.add(111);

    }
}
