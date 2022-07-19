package com.lifeng.java.day12.exer;

import java.util.Objects;
import java.util.Scanner;

/**
 * 6.需求：以字符串的形式从键盘录入学生信息，例如："张三,23" 从该字符串中切割出有效数据，封装为Student学生对象
 * @author lifeng
 * @create 2022-07-05 20:43
 */
public class exer7 {
    public static void main(String[] args) {

        Student student = new Student();

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生信息");
        String studentMassage = scanner.next();

        String[] split = studentMassage.split(",");
        for (int i = 0;i < split.length;i++) {
            student.setName(split[i]);
            student.setAge(split[i+1]);
            break;
        }

        System.out.println("学生姓名为" + student.getName() + "学生年龄为：" + student.getAge());

    }
}

class Student{
    private String name;
    private String age;

    public Student() {
    }

    public Student(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(age, student.age);
    }

}
