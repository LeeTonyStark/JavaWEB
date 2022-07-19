package com.lifeng.java.day16.exer;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author lifeng
 * @create 2022-07-09 15:01
 */
public class exer2 {
    public static void main(String[] args) {

        ArrayList<Student> arr = new ArrayList<>();

        arr.add(new Student("a001","黄渤",1.72));
        arr.add(new Student("a002","孙红雷",1.78));
        arr.add(new Student("a003","章子怡",1.64));
        arr.add(new Student("a004","杨颖",1.68));

        Object[] objects = arr.toArray();
        for (int i = 0; i < objects.length; i++) {
            Student student = (Student) objects[i];
            System.out.println("ID:" + student.getId() + "Name:" + student.getName() + "身高:" + student.getHeight());
        }

        System.out.println("集合大小：" + arr.size());

        System.out.println(arr.get(2).toString());

        arr.remove(3);

        System.out.println("集合大小："+arr.size());

        arr.set(0,new Student("a005","撒贝宁",1.67));
        System.out.println(arr);

        Object[] objects1 = arr.toArray();
        for (int i = 0; i < objects1.length; i++) {
            Student student = (Student)objects1[i];
            if (student.getHeight()>1.70){
                System.out.println("身高在1.70以上的：");
                System.out.println(student);
            }
        }

        for (int i = 0; i < objects1.length; i++) {
            Student student = (Student)objects1[i];
            if (student.getName().contains("孙")){
                System.out.println("包含孙的学生：");
                System.out.println(student);
            }
        }

    }
}

class Student{
    private String id;
    private String name;
    private double height;

    public Student() {
    }

    public Student(String id, String name, double height) {
        this.id = id;
        this.name = name;
        this.height = height;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", height=" + height +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return id == student.id && height == student.height && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, height);
    }

}
