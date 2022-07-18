package com.lifeng.java.day16.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 已知：有一个集合容器，里面存储了三个学生对象，然后遍历集合，打印出这三个学生对象的属性
 * @author lifeng
 * @create 2022-07-09 11:33
 */
public class demo5 {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add(new Student("张三",85,21));
        list.add(new Student("李四",75,20));
        list.add(new Student("王五",89,23));

        Object[] objects = list.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }

    }
}

class Student{
    private String name;//姓名
    private int score;//成绩
    private int age;//年龄

    public Student() {
    }

    public Student(String name, int score, int age) {
        this.name = name;
        this.score = score;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", age=" + age +
                '}';
    }
}