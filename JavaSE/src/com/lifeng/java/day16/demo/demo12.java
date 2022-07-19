package com.lifeng.java.day16.demo;

import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author lifeng
 * @create 2022-07-11 16:15
 */
public class demo12 {
    public static void main(String[] args) {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(new Pig1("佩奇",12));
        arrayList.add(new Pig1("乔治",11));
        arrayList.add(new Pig1("乔治爸爸",21));

        for (Object o : arrayList) {
            Pig1 pig1 = (Pig1) o;
            System.out.println(pig1.getName() + "\t" + pig1.getAge());
        }
    }
}

class Pig1{
    private String name;
    private int age;

    public Pig1() {
    }

    public Pig1(String name, int age) {
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
        return "Pig1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pig1)) return false;
        Pig1 pig1 = (Pig1) o;
        return age == pig1.age && Objects.equals(name, pig1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}