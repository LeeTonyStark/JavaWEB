package com.lifeng.java.day16.exer;

import java.util.ArrayList;

/**
 *
 * 5.分析以下需求，并用代码实现
 * 	1.定义Student类
 * 		属性:
 * 			姓名：String name
 * 			年龄：int age
 * 			成绩：int score
 * 		行为:
 * 			空参构造方法
 * 			有参构造方法
 * 			set和get方法
 * 			toString方法
 * 	2.定义测试类,进行测试
 * 		(1)创建5个学生对象存入ArrayList集合中
 * 		(2)打印最高分的学员姓名、年龄、成绩  [要求封装1个方法  参数是集合对象   返回值类型为Student]
 * 		(3)打印5个学生的总成绩和平均分		 [要求封装两个方法完成]
 * 		(4)打印不及格的学员信息及数量		 [要求封装一个方法完成]
 * @author lifeng
 * @create 2022-07-11 17:21
 */
public class exer7 {
    public static void main(String[] args) {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(new Student3("学生一",22,93));
        arrayList.add(new Student3("学生二",22,53));
        arrayList.add(new Student3("学生三",22,43));
        arrayList.add(new Student3("学生四",22,33));
        arrayList.add(new Student3("学生五",22,83));

        System.out.println(arrayList);
        //(2)打印最高分的学员姓名、年龄、成绩
        Student3 student3 = new Student3();
        Student3 maxStudent = student3.getMaxStudent(arrayList);
        System.out.println(maxStudent);

        //(3)打印5个学生的总成绩和平均分
        student3.printTotalScore(arrayList);
        student3.avgScore(arrayList);
        //(4)打印不及格的学员信息及数量
        student3.printBelowStandardStudentAndSum(arrayList);

    }
}
class Student3{
    private String name;
    private int age;
    private int score;

    public Student3() {
    }

    public Student3(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
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

    @Override
    public String toString() {
        return "Student3{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    //(2)打印最高分的学员姓名、年龄、成绩  [要求封装1个方法  参数是集合对象   返回值类型为Student]

    /**
     * 获取最高分的学生
     * @param list
     * @return
     */
    public Student3 getMaxStudent(ArrayList list){
        //找出最高分成绩的学生
        Student3 maxScoreStudent = new Student3();//接收最高分成绩的学生
        for (Object o : list) {
            Student3 student3 = (Student3) o;
            if (student3.getScore() > maxScoreStudent.getScore()){
                maxScoreStudent = student3;
            }
        }

        return maxScoreStudent;

    }

    //(3)打印5个学生的总成绩和平均分		 [要求封装两个方法完成]

    /**
     * 打印学生总成绩
     * @param list 集合对象
     * @return
     */
    public void printTotalScore(ArrayList list){
        int sumScore = 0;//记录总成绩

        for (Object o : list) {
            Student3 student3 = (Student3) o;
            sumScore += ((Student3) o).getScore();
        }

        System.out.println("学生总成绩为："+sumScore);
    }


    public void avgScore(ArrayList list){

        int sumScore = 0;//接收总成绩
        for (Object o : list) {
            Student3 student3 = (Student3) o;
            sumScore = student3.getScore();
        }
        System.out.println("学生总成绩为：" + sumScore);
    }

    //(4)打印不及格的学员信息及数量		 [要求封装一个方法完成]
    public void printBelowStandardStudentAndSum(ArrayList list){
        int Count = 0;//记录不合格学生
        for (Object o : list) {
            Student3 student3 = (Student3) o;
            if (student3.getScore() < 60){
                Count++;
                System.out.println("不合格学生："+student3);
            }
        }
        System.out.println("不合格的学生数量为：" + Count);
    }

}
