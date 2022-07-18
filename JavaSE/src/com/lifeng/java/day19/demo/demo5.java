package com.lifeng.java.day19.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author lifeng
 * @create 2022-07-14 14:25
 */
public class demo5 {
    public static void main(String[] args) {
        ArrayList<Person> arrayList = new ArrayList<>();
        arrayList.add(new Person("张三",1));
        arrayList.add(new Person("李四",2));
        arrayList.add(new Person("赵钱",3));
        arrayList.add(new Person("孙李",4));

        Collections.sort(arrayList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int i = o2.getAge() - o1.getAge();
                int name = i == 0 ? o1.getName().compareTo(o2.getName()) : i;
                return name;
            }
        });

        for (Person person : arrayList) {
            System.out.println(person);
        }
    }
}
