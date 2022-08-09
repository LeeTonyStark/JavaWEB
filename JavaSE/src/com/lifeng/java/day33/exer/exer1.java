package com.lifeng.java.day33.exer;

import java.io.*;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 1. 要求键盘录入学生的信息，按照格式：学生姓名;语文成绩;数学成绩;英语成绩
 * 要求录入5位学生的信息，并将录入的5位学生的信息按照总分由高到低的顺序写入项目文件夹下的students.txt中。（姓名成绩相同不去重）
 * 例如： 键盘录入：
 * 		张三;90;90;90
 * 		王五;60;60;60
 * 		王五;60;60;60
 * 		赵六;80;80;80
 * 		周七;70;70;70
 * 写入文件格式为：
 * 		张三;90;90;90
 *      赵六;80;80;80
 *      周七;70;70;70
 *      王五;60;60;60
 * 		王五;60;60;60
 * @author lifeng
 * @create 2022-08-08 17:01
 */
public class exer1 {
    public static void main(String[] args) throws IOException {
        //存储学生信息
        TreeSet<Student> set = new TreeSet<Student>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //姓名成绩相同不去重
                int i1 = o1.toString().compareTo(o2.toString());
                //总分由高到低
                int i = i1 == 0 ? 1 : o2.getSumScore() - o1.getSumScore();
                return i;
            }
        });
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生信息，输入886结束(格式:张三;90;90;90)");

        while (true){
            String s = scanner.nextLine();
            if ("886".equals(s)){
                scanner.close();
                break;
            }
            String[] split = s.split(";");
            //存储信息到set集合
            set.add(new Student(split[0],Integer.parseInt(split[1]),Integer.parseInt(split[2]),Integer.parseInt(split[3])));
        }

        //得到键盘录入的信息后，写入到文件夹中
        BufferedWriter bos = new BufferedWriter(new FileWriter("d.txt"));
        for (Student student : set) {
            String name = student.getName();
            int yuwen_score = student.getYuwen_score();
            int shuxue_score = student.getShuxue_score();
            int yingyu_score = student.getYingyu_score();
            String s = name + ";" + String.valueOf(yuwen_score) + ";" + String.valueOf(shuxue_score) + ";" + String.valueOf(yingyu_score);
            bos.write(s);
            bos.newLine();
            bos.flush();
        }
        bos.close();

    }
}

class Student{
    //学生姓名;语文成绩;数学成绩;英语成绩
    private String name;
    private int yuwen_score;
    private int shuxue_score;
    private int yingyu_score;

    public Student() {
    }

    public Student(String name, int yuwen_score, int shuxue_score, int yingyu_score) {
        this.name = name;
        this.yuwen_score = yuwen_score;
        this.shuxue_score = shuxue_score;
        this.yingyu_score = yingyu_score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYuwen_score() {
        return yuwen_score;
    }

    public void setYuwen_score(int yuwen_score) {
        this.yuwen_score = yuwen_score;
    }

    public int getShuxue_score() {
        return shuxue_score;
    }

    public void setShuxue_score(int shuxue_score) {
        this.shuxue_score = shuxue_score;
    }

    public int getYingyu_score() {
        return yingyu_score;
    }

    public void setYingyu_score(int yingyu_score) {
        this.yingyu_score = yingyu_score;
    }

    public int getSumScore(){
        return yuwen_score + shuxue_score + yingyu_score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", yuwen_score=" + yuwen_score +
                ", shuxue_score=" + shuxue_score +
                ", yingyu_score=" + yingyu_score +
                '}';
    }
}