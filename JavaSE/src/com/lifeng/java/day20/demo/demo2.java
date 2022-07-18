package com.lifeng.java.day20.demo;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 第四周考试编程题第1题
 * @author lifeng
 * @create 2022-07-15 17:26
 */
public class demo2 {


    @Override
    public int hashCode() {
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("c");
        list.add("a");
        list.add("c");
        list.add("e");
        list.add("e");
        list.add("c");
        list.add("e");
        list.add("e");
        list.add("b");
        list.add("b");
        list.add("b");
        list.add("c");

        HashSet<String> set = new HashSet<>();
        for (String s : list) {
            set.add(s);
        }

        for (String s : set) {
            System.out.println(s);
        }



    }
}
