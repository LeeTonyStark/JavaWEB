package com.lifeng.java.day17.exer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 2.分析以下需求，并用代码实现：
 *  (1)定义一个Person类型(属性私有、空参有参构造)、set、get方法、等
 *  (2)list集合中存储多个Person对象，获取年龄最大的Person对象并打印信息
 * @author lifeng
 * @create 2022-07-11 20:58
 */
public class exer2 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Person("q",12));
        list.add(new Person("w",13));
        list.add(new Person("z",20));

        Person person = new Person();//用于存储年龄最大的Person对象
        for (Object o : list) {
            Person p = (Person) o;
            if (p.getAge() > person.getAge()){
                person = p;
            }
        }
        System.out.println(person);
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
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}