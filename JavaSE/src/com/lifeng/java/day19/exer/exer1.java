package com.lifeng.java.day19.exer;

import java.util.*;

/**
 * 1.分析以下需求，并用代码实现：
 * 	(1)定义一个学生类Student，包含属性：姓名(String name)、年龄(int age)
 * 	(2)定义Map集合，用Student对象作为key，用字符串(此表示表示学生的住址)作为value
 * 	(3)利用四种方式遍历Map集合中的内容，格式：key::value
 * @author lifeng
 * @create 2022-07-14 17:43
 */
public class exer1 {
    public static void main(String[] args) {

        Map<Student,String> map = new HashMap();

        map.put(new Student("小赵",16),"内蒙古");
        map.put(new Student("小王",17),"新疆");
        map.put(new Student("小李",16),"西藏");
        map.put(new Student("小孙",18),"四川");
        map.put(new Student("小刘",15),"江苏");

        //方式一：
        Set<Student> collection = map.keySet();
        for (Student key: collection){
            String value = map.get(key);
            System.out.println(key+"::"+value);
        }
        System.out.println("------------------------------------------");
        //方式二：
        for (Map.Entry<Student, String> studentStringEntry : map.entrySet()) {
            Student key = studentStringEntry.getKey();
            String value = studentStringEntry.getValue();
            System.out.println(key + "::" + value);
        }
        System.out.println("------------------------------------------");
        //方式三：
        Iterator<Map.Entry<Student, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Student, String> next = iterator.next();
            System.out.println(next.getKey() + "::" + next.getValue());
        }
        System.out.println("------------------------------------------");
        //方式四:
        Iterator<Student> iterator1 = map.keySet().iterator();
        while (iterator1.hasNext()){
            Student next = iterator1.next();
            String value = map.get(next);
            System.out.println(next + "::" + value);
        }


    }
}
class Student{
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
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
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}