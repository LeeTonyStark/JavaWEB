package com.lifeng.java.day16.demo;

import java.util.ArrayList;

/**
 * @author lifeng
 * @create 2022-07-11 15:25
 */
public class demo11 {
    public static void main(String[] args) {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add("aaa");
        arrayList.add("bbb");
        arrayList.add("aaa");
        arrayList.add("aaa");
        arrayList.add("ccc");
        arrayList.add("ddd");

        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).equals("aaa")){
                arrayList.remove(i);
                i--;
            }
            System.out.println(arrayList.get(i));
        }
    }
}
