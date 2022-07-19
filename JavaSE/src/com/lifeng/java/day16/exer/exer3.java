package com.lifeng.java.day16.exer;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author lifeng
 * @create 2022-07-09 15:33
 */
public class exer3 {
    public static void main(String[] args) {
        ArrayList<Student1> students1 = new ArrayList<>();
        students1.add(new Student1("a001","黄渤","男",20,1.72));
        students1.add(new Student1("a002","孙红雷","男",22,1.78));
        students1.add(new Student1("a003","章子怡","女",18,1.64));

        System.out.println(students1);

        //打印学员信息
        printAll(students1);
        //找到身高最高学员信息
        findMaxHeight(students1);


    }

    //可以打印所有学生信息的方法
    public static void printAll(ArrayList<Student1> stuList){
        if (stuList.size() == 0){
            return;
        }
        Object[] objects = stuList.toArray();
        for (int i = 0; i < objects.length; i++) {
            Student1 student1 = (Student1) objects[i];
            System.out.println("学号：" + student1.getId() + "  姓名:" + student1.getName() + "  性别:" +student1.getSex()
            + "  年龄:" + student1.getAge() + "  身高:" + student1.getHeight());
        }
    }

    //找出身高最高的学员并打印
    public static void findMaxHeight(ArrayList<Student1> student1s){
        if (student1s.size() == 0){
            return;
        }
        Student1 student11 = new Student1();
        Object[] objects = student1s.toArray();
        for (int i = 0; i < objects.length; i++) {
            //向下转型
            Student1 student1 = (Student1) objects[i];
            if (student1.getHeight() > student11.getHeight()) {
                student11 = student1;
            }
        }

        System.out.println("身高最高的学员是:" + student11.toString());
    }

}

class Student1{
    private String id;
    private String name;
    private String sex;
    private int age;
    private double height;

    public Student1() {
    }

    public Student1(String id, String name, String sex, int age, double height) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student1)) return false;
        Student1 student1 = (Student1) o;
        return age == student1.age && Double.compare(student1.height, height) == 0 && Objects.equals(id, student1.id) && Objects.equals(name, student1.name) && Objects.equals(sex, student1.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sex, age, height);
    }

    @Override
    public String toString() {
        return "Student1{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}

