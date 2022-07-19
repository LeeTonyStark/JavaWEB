package com.lifeng.java.day16.exer;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author lifeng
 * @create 2022-07-09 16:02
 */
public class exer4 {

    public static void main(String[] args) {

        Student2[] student2s = {new Student2("旺财",21,61),
                new Student2("小翠",22,77),
                new Student2("张三",20,51),
                new Student2("王五",19,50),
                new Student2("ooo",32,90),
                new Student2("wo31",19,43),
                new Student2("admin",31,75)};


        StudentsTool studentsTool = new StudentsTool();

        System.out.println("打印学生信息");
        studentsTool.listStudents(student2s);
        System.out.println("获取学生成绩最高分");
        System.out.println(studentsTool.getMaxScore(student2s));
        System.out.println("获取成绩最高的学员");
        System.out.println(studentsTool.getMaxStudent(student2s));
        System.out.println("获取学生成绩的平均值");
        System.out.println(studentsTool.getAverageScore(student2s));
        System.out.println("获取不及格的学员数量");
        System.out.println(studentsTool.getCount(student2s));


    }

}

/**
 * 学生工具类
 */
class StudentsTool{

    //遍历打印学生信息
    public void listStudents(Student2[] arr){
        for (Student2 student2 : arr) {
            System.out.println(student2);
        }
    }

    //获取学生成绩的最高分
    public int getMaxScore(Student2[] arr){
        int max = 0;
        for (Student2 student2 : arr) {
            if (student2.getScore() > max){
                max = student2.getScore();
            }
        }
        return max;
    }

    //获取成绩最高的学员
    public Student2 getMaxStudent(Student2[] arr){
        Student2 maxStudent = new Student2();
        for (Student2 student : arr) {
            if (student.getScore() > maxStudent.getScore()){
                maxStudent = student;
            }
        }
        return maxStudent;
    }

    //获取学生成绩的平均值
    public int getAverageScore(Student2[] arr){
        int avg = 0;//存储平均值
        for (Student2 student2 : arr) {
            avg += student2.getScore();
        }
        return avg/arr.length;
    }

    //获取不及格的学员数量
    public int getCount(Student2[] arr){
        int Count = 0;//存储不及格学生数量
        for (Student2 student2 : arr) {
            if (student2.getScore() < 60){
                Count++;
            }
        }
        return Count;
    }

}

/**
 * 学生类
 */
class Student2{
    private String name;
    private int age;
    private int score;

    public Student2(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public void eat(){
        System.out.println("吃饭方法");
    }

    public String study(String content){
        return content;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Student2)) return false;
        Student2 student2 = (Student2) o;
        return age == student2.age && score == student2.score && Objects.equals(name, student2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, score);
    }

    @Override
    public String toString() {
        return "Student2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student2() {
    }
}
