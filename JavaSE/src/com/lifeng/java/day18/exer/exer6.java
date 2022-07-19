package com.lifeng.java.day18.exer;

import java.util.ArrayList;
import java.util.List;

/**
 * 6.创建学生对象(Student类),包含学生信息(姓名和年龄),创建对应get、set方法,有参构造和无参构造。
 *   1、向List集合添加学生信息。
 *   2、把List集合中学生姓李的同学打印到控制台：(格式为：姓名为：李四,年龄为：24)
 * @author lifeng
 * @create 2022-07-13 20:25
 */
public class exer6 {
    public static void main(String[] args) {
        List<Student> stu = new ArrayList<>();
        stu.add(new Student("小赵",21));
        stu.add(new Student("李狗蛋",24));
        stu.add(new Student("小孙",22));
        stu.add(new Student("小王",21));

        for (Student student : stu) {
            if (student.getName().startsWith("李")){
                System.out.println("姓名为:" + student.getName() + ",年龄为：" + student.getAge());
            }
        }

    }
}

