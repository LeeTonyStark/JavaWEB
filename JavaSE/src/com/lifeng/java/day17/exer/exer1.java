package com.lifeng.java.day17.exer;

import java.util.ArrayList;

/**
 * 1.分析以下需求，并用代码实现：
 *  (1)定义一个swap()传入集合和两个角标使集合中元素交换位置()
 * @author lifeng
 * @create 2022-07-11 20:37
 */
public class exer1 {
    public static void main(String[] args) {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add("aaa");
        arrayList.add("bbb");
        arrayList.add("ccc");
        swap(arrayList,2,1);
        System.out.println(arrayList);
    }

    public static void swap(ArrayList list,int i,int j){
        if (i == 0 || j == 0){
            return;
        }
        Object o = list.get(0);
        o = list.get(i);
        list.set(i,list.get(j));
        list.set(j,o);
    }
}
