package com.lifeng.java.day16.demo;

import java.util.LinkedList;

/**
 * @author lifeng
 * @create 2022-07-11 16:37
 */
public class demo13 {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("aada");
        linkedList.add("121313");
        linkedList.add(38394);

        linkedList.addFirst("1212");
        linkedList.addLast("fdfsdf");


        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        System.out.println();

        linkedList.removeFirst();
        linkedList.removeLast();

        System.out.println();

        for (Object o : linkedList) {
            System.out.println(o);
        }
    }
}
