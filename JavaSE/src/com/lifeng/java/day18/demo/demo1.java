package com.lifeng.java.day18.demo;

import java.util.TreeSet;

/**
 * @author lifeng
 * @create 2022-07-13 10:42
 */
public class demo1 {
    public static void main(String[] args) {
        TreeSet<A> pig = new TreeSet<>();
        pig.add(new A("佩奇",12));
        pig.add(new A("乔治",13));
        pig.add(new A("乔治爸爸",22));
        pig.add(new A("乔治爸爸",22));
        pig.add(new A("乔治爸爸1",22));
        System.out.println(pig);
    }
}
class A implements Comparable<A>{

    private String name;
    private int age;

    public A() {
    }

    public A(String name, int age) {
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
        return "A{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
//    @Override
//    public int compareTo(A o) {
//
//        return o.age - this.age;
//    }

    @Override
    public int compareTo(A o) {
        if (o.age==this.age){
            return o.name.compareTo(this.name);
        }
        return o.age - this.age;
    }
}
