package com.lifeng.java.day17.exer;

import java.util.ArrayList;
import java.util.List;

/**
 * 5.分析以下需求，并用代码实现：
 * 	定义一个replaceAll方法,用传入集合的新值替换集合中的老值(list,old,new)
 * @author lifeng
 * @create 2022-07-12 18:45
 */
public class exer5 {
    public static void main(String[] args) {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add("123444");
        arrayList.add("1212sa");
        arrayList.add("aaa");
        arrayList.add("aaa");
        arrayList.add("aaa");
        arrayList.add("12");
        System.out.println(arrayList);
        System.out.println(replaceAll(arrayList, "aaa", "bbb"));
    }

    //定义一个replaceAll方法,用传入集合的新值替换集合中的老值(list,old,new)
    public static List replaceAll(List list, String oldStr, String newStr){
        Object[] objects = list.toArray();
        for (int i = 0; i < objects.length; i++) {
            if (objects[i].toString().equals(oldStr)){
                list.set(i,newStr);
            }
        }
        return list;
    }
}
