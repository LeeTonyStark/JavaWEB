package com.lifeng.java.day17.demo;

import java.util.Comparator;
import java.util.Objects;
import java.util.TreeSet;

/**
 * @author lifeng
 * @create 2022-07-12 15:35
 */
public class demo6 {
    public static void main(String[] args) {
        TreeSet<String> s = new TreeSet<>();
        TreeSet<Integer> integers = new TreeSet<>();
        TreeSet<Pig> t = new TreeSet<Pig>(new Comparator<Pig>() {
            @Override
            public int compare(Pig o1, Pig o2) {
                return -1;
            }
        });
        s.add("ccc");
        s.add("bbb");
        s.add("aaa");
        for (String s1 : s) {
            System.out.println(s1);
        }

        integers.add(333);
        integers.add(222);
        integers.add(111);
        for (Integer integer : integers) {
            System.out.println(integer);
        }

        t.add(new Pig("佩奇","女"));
        t.add(new Pig("乔治","男"));
        t.add(new Pig("乔治爸爸","男"));
        for (Pig pig : t) {
            System.out.println(pig);
        }

    }
}
class Pig{
    private String name;
    private String sex;

    public Pig() {
    }

    public Pig(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return sex;
    }

    public void setAge(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Pig{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pig)) return false;
        Pig pig = (Pig) o;
        return Objects.equals(name, pig.name) && Objects.equals(sex, pig.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex);
    }
}
