package com.lifeng.java.day16.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

/**
 * @author lifeng
 * @create 2022-07-11 10:23
 */
public class demo7 {
    public static void main(String[] args) {
        //创建集合对象
        ArrayList<Object> arrayList = new ArrayList<>();
        ArrayList<Object> arrayList1 = new ArrayList<>();

        //将元素添加到容器
        arrayList1.add("tjrq");

        arrayList.add("abc123");
        arrayList.add("ppp");
        arrayList.add(112233);
        arrayList.add(true);
        arrayList.add(false);
        arrayList.add(new Object());

        //将集合中的元素添加到容器
        arrayList1.addAll(arrayList);
        System.out.println(arrayList);
        System.out.println(arrayList1);

        //void clear():清空容器中的元素
//        arrayList1.clear();
        //isEmpty():判断是否为空
        System.out.println(arrayList.isEmpty());

        //remove():删除元素
        arrayList.remove("ppp");
        System.out.println(arrayList);

        //removeIf():根据条件删除
        arrayList.removeIf(new Predicate<Object>() {
            @Override
            public boolean test(Object o) {
                return o.toString().length() > 5;
            }
        });

        System.out.println(arrayList);

        //size()
        System.out.println(arrayList.size());

        Object[] objects = arrayList.toArray();
        for (Object object : objects) {
            System.out.println(object);
        }

        System.out.println("方式一：*****************");

        Object[] objects1 = arrayList.toArray();
        for (int i = 0; i < objects1.length; i++) {
            System.out.println(objects1[i]);
        }

        System.out.println("方式二*******************");

        Iterator<Object> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }

        System.out.println("方式三*******************");
        for (Object o : arrayList) {
            System.out.println(o);
        }

        int[] arr = {1,2,3,4,5,6};
        for (int i : arr) {
            System.out.println(i);
        }


    }
}
