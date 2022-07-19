package com.lifeng.java.day22.exer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 2.从控制台接收3名学员的信息，每条进行存储到一个Student对象中，将多个Student对象存储到一个集合中。
 * 输入完毕后，将所有学员信息存储到文件Student.txt中。每名学员信息存储一行，多个属性值中间用逗号隔开。
 * @author lifeng
 * @create 2022-07-19 19:56
 */
public class exer2 {
    public static void main(String[] args){
        boolean flag = true;
        ArrayList<Student> list = new ArrayList<>();//存储学生对象

        while (flag){
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入学生的学号,姓名，性别。(中间均以逗号隔开)");
            String next = scanner.next();
            Student student = new Student();
            String[] split = next.split(",");
            student.setSid(Integer.parseInt(split[0]));
            student.setName(split[1]);
            student.setSex(split[2]);

            list.add(student);//将存好数据的学生对象装进list集合中
            if (list.size() >= 3){
                System.out.println("程序结束,输入终止！");
                flag = false;
            }
        }

        Writer writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("Student.txt"));
            for (Student student : list) {
                String s = student.toString();
                try {
                    writer.write(s+"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    writer.flush();//刷新管道
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (writer != null){
                try {
                    writer.close();//关闭流
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }
}

class Student{
    private Integer sid;//学号
    private String name;//姓名
    private String sex;//性别


    public Student() {
    }

    public Student(Integer sid, String name, String sex) {
        this.sid = sid;
        this.name = name;
        this.sex = sex;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
