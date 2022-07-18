package com.lifeng.java.day15.demo;

import com.lifeng.java.day15.AgeNotLess;

/**
 * @author lifeng
 * @create 2022-07-08 14:33
 */
public class demo5 {
    public static void main(String[] args) {
        Person person = new Person("翠花",-11);
        System.out.println(person.getAge());
    }
}

class Person{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
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
        if (age <= 0){
            throw new AgeNotLess("年龄不能低于0");
        }else {
            return age;
        }
    }

    public void setAge(int age) {
        this.age = age;
    }
}
