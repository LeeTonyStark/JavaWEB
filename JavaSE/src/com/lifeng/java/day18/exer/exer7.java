package com.lifeng.java.day18.exer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 7.请用LinkedList的集合模拟栈数据结构，并测试
 * @author lifeng
 * @create 2022-07-13 20:33
 */
public class exer7 {

    public static void main(String[] args) {
        List list = new LinkedList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add(12121);
        list.add(true);


        //模拟取出元素
        stackTest(list);
    }

    /**
     * 模拟栈先进后出的特点
     * @param list
     * @return
     */
    public static void stackTest(List<Object> list){
        for (int i = list.size() - 1; i >= 0;i--) {
            System.out.println(list.get(i));
        }
    }
}


