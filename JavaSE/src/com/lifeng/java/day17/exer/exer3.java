package com.lifeng.java.day17.exer;

import java.util.ArrayList;

/**
 * 3.分析以下需求，并用代码实现：
 *  （1）将集合中的元素反转
 * @author lifeng
 * @create 2022-07-11 21:16
 */
public class exer3 {
    public static void main(String[] args) {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add("aaa");
        arrayList.add("bbb");
        arrayList.add("ccc");
        arrayList.add("ddd");
        arrayList.add("eee");

        for (int i = 0,j = arrayList.size() - 1;i < j;i++,j--){
            Object temp = arrayList.get(i);
            arrayList.set(i,arrayList.get(j));
            arrayList.set(j,temp);
        }
        System.out.println(arrayList);
    }
}
