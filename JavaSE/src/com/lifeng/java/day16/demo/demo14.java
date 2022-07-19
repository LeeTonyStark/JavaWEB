package com.lifeng.java.day16.demo;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author lifeng
 * @create 2022-07-11 16:46
 */
public class demo14 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add("12121");
        list.add("asas");
        list.add("121www");

        //1.
        for (Object o : list) {
            System.out.println(o);
        }

        //2.
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //3.
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //4.
        Object[] objects = list.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }

    }
}
