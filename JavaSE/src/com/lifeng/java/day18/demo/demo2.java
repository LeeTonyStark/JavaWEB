package com.lifeng.java.day18.demo;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author lifeng
 * @create 2022-07-13 11:30
 */
public class demo2 {
    public static void main(String[] args) {
//        TreeSet<B> bs = new TreeSet<>(new Comparator<B>() {
//            @Override
//            public int compare(B o1, B o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        });

//        TreeSet<B> bs = new TreeSet<>(new Comparator<B>() {
//            @Override
//            public int compare(B o1, B o2) {
//                return o2.getAge() - o1.getAge();
//            }
//        });

        TreeSet<B> bs = new TreeSet<>(new Comparator<B>() {
            @Override
            public int compare(B o1, B o2) {

                int i = o2.getAge() - o1.getAge();

                int i1 = i == 0 ? o1.getName().compareTo(o2.getName()) : i;

                return i1;
            }
        });
        bs.add(new B("佩奇",12));
        bs.add(new B("乔治",13));
        bs.add(new B("乔治爸爸",22));
        bs.add(new B("乔治爸爸",22));
        bs.add(new B("乔治爸爸1",22));

        System.out.println(bs);
    }
}

class B{
    private String name;
    private int age;

    public B() {
    }

    public B(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "B{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
