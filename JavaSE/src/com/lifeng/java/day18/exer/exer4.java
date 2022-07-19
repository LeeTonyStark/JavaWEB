package com.lifeng.java.day18.exer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 3.一个学科中有若干班级，每一个班级又有若干学生。
 *   请使用集合嵌套之ArrayList嵌套ArrayList描述这种关系，要求如下：
 * 	1、学生类有两个属性，姓名和年龄，并定义有参构造、无参构造、setter和getter方法
 * 	2、向班级集合中添加若干学生（至少两个学生）。
 * 	3、向学科集合中添加所有班级（至少两个班级）。
 * 	4、使用两种方式遍历学科集合并打印出所有学生。
 * @author lifeng
 * @create 2022-07-13 19:59
 */
public class exer4 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Student>> subject = new ArrayList<>();//学科集合
        ArrayList<Student> classStu1 = new ArrayList<>();//班级集合
        classStu1.add(new Student("张三",20));
        classStu1.add(new Student("李四",21));


        ArrayList<Student> classStu2 = new ArrayList<>();//班级集合
        classStu2.add(new Student("王五",20));
        classStu2.add(new Student("赵四",21));


        subject.add(classStu1);
        subject.add(classStu2);

        //方式一：先取出里面的班级，再取出里面的学生
        for (ArrayList<Student> students : subject) {
            for (Student student : students) {
                System.out.println(student);
            }
        }

        //方式二：
        Iterator<ArrayList<Student>> iterator = subject.iterator();
        while (iterator.hasNext()){
            ArrayList<Student> next = iterator.next();
            Iterator<Student> iterator1 = next.iterator();
            while (iterator1.hasNext()){
                System.out.println(iterator1.next());
            }
        }

    }
}

/**
 * 学生类
 */
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
