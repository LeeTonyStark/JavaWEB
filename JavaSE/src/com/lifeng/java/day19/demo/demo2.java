package com.lifeng.java.day19.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author lifeng
 * @create 2022-07-14 11:18
 */
public class demo2 {
    public static void main(String[] args) {
        //键为String,值为Person
        HashMap<String,Person> hashMap = new HashMap<>();

        hashMap.put("aaa",new Person("佩奇",12));
        hashMap.put("bbb",new Person("乔治",13));
        hashMap.put("ccc",new Person("乔治妈妈",22));

        Set<Map.Entry<String, Person>> entries = hashMap.entrySet();
        for (Map.Entry<String, Person> entry : entries) {
            String key = entry.getKey();
            Person value = entry.getValue();
            System.out.println(key + "..." + value);
        }


        System.out.println("-------------------------------");

        //键为Person，值为String
        HashMap<Person, String> personStringHashMap = new HashMap<>();
        personStringHashMap.put(new Person("佩奇1",21),"pig");
        personStringHashMap.put(new Person("佩奇2",21),"pig");
        personStringHashMap.put(new Person("佩奇3",21),"pig");

        Set<Map.Entry<Person, String>> entries1 = personStringHashMap.entrySet();
        for (Map.Entry<Person, String> personStringEntry : entries1) {
            Person key = personStringEntry.getKey();
            String value = personStringEntry.getValue();
            System.out.println(key + "..." + value);
        }
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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

//    @Override
//    public int compareTo(Person o) {
//        return this.getAge() - ((Person) o).getAge();
//    }
}
