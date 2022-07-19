package com.lifeng.java.day16.exer;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * 6.分析以下需求，并用代码实现
 * 	1.定义ArrayList集合，存入多个字符串
 * 	   如:"ab1" "123ad"  "bca" "dadfadf"  "dddaaa"  "你好啊"  "我来啦"  "别跑啊"
 * 	2.遍历集合,删除长度大于5的字符串,打印删除后的集合对象
 * 	3.基于上一步,删除集合中元素包含0-9数字的字符串(只要字符串中包含0-9中的任意一个数字就需要删除此整个字符串)
 * @author lifeng
 * @create 2022-07-09 16:57
 */
public class exer5 {
    public static void main(String[] args) {
        ArrayList<Object> arrayList = new ArrayList<>();

        arrayList.add("ab1");
        arrayList.add("123ab");
        arrayList.add("bca");
        arrayList.add("dadfadf");
        arrayList.add("dddaaa");
        arrayList.add("你好啊");
        arrayList.add("我来啦");
        arrayList.add("别跑啊");

        Object[] objects = arrayList.toArray();
        for (int i = 0; i < objects.length; i++) {

            if (objects[i].toString().length() > 5){
                arrayList.remove(objects[i]);
            }
            for (int j = 0; j < objects[i].toString().length(); j++) {
                if (objects[i].toString().charAt(j) > '0' && objects[i].toString().charAt(j) < '9') {
                    arrayList.remove(objects[i]);
                }
            }
        }
        System.out.println(arrayList);
    }
}
