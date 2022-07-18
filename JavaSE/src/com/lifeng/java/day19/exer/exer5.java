package com.lifeng.java.day19.exer;

import java.util.*;

/**
 * 5.分析以下需求，并用代码实现：
 * 	(1)定义一个学生类Student，属性：姓名(String name)、班级班号(String no)、成绩(double score)
 * 	(2)将若干Student对象存入List集合，并统计每个班级的总分和平均分
 * 		思路：
 * 			a.采用面向对象的思想
 * 			b.不推荐使用Map<String,List<Student>> 操作不方便
 * 			c.推荐使用Map<String，ClassRoom>
 * @author lifeng
 * @create 2022-07-14 20:25
 */
public class exer5 {
    public static void main(String[] args) {

        double allScore1 = 0;//这个用于记录班级总分
        double allScore2 = 0;//这个用于记录班级总分
//        double avgScore1 = 0;//这个用于记录班级平均分
//        double avgScore2 = 0;//这个用于记录班级平均分
        int oneCount = 0;
        int twoCount = 0;

        ClassRoom one = new ClassRoom("一班");
        ClassRoom two = new ClassRoom("二班");

        Student1 student1 = new Student1("张三", "no1", 93.5);
        Student1 student2 = new Student1("李四", "no1", 85.5);
        Student1 student3 = new Student1("孙杨", "no1", 79.5);
        Student1 student4 = new Student1("佩奇", "no2", 73.5);
        Student1 student5 = new Student1("乔治", "no2", 95.5);
        Student1 student6 = new Student1("乔治妈妈", "no2", 79.5);

        List<Student1> list = new LinkedList();//list集合存储学生对象
        List<Student1> list1 = new LinkedList();//list集合存储学生对象

        list.add(student1);
        list.add(student2);
        list.add(student3);
        list1.add(student4);
        list1.add(student5);
        list1.add(student6);

        one.setStudent1s(list);
        two.setStudent1s(list1);

        //创建一个map集合存储班级和学生
        Map<String,ClassRoom> map = new HashMap<>();
        map.put("一班",one);
        map.put("二班",two);
        Set<Map.Entry<String, ClassRoom>> entries = map.entrySet();
        for (Map.Entry<String, ClassRoom> entry : entries) {
            String key = entry.getKey();
            ClassRoom value = entry.getValue();
            //统计班级总分
            if (key.equals("一班")){
                List<Student1> student1s = value.getStudent1s();
                for (Student1 student11 : student1s) {
                    allScore1 += student11.getScore();
                    oneCount++;
                }
            }
            if (key.equals("二班")){
                List<Student1> student1s = value.getStudent1s();
                for (Student1 student11 : student1s) {
                    allScore2 += student11.getScore();
                    twoCount++;
                }
            }
            System.out.println(key + "..." + value);
        }


        //打印输出
        System.out.println("一班总分为:"+allScore1);
        System.out.println("二班总分为:"+allScore2);
        System.out.println("一班平均分为:"+allScore1/oneCount);
        System.out.println("一班平均分为:"+allScore2/oneCount);

    }
}

/**
 * 采用面向对象思想，一个班级中，必然包含多个学生，采用一对多关系
 */
class ClassRoom{
    private String no;
    private List<Student1> student1s;

    public ClassRoom() {
    }

    public ClassRoom(String no) {
        this.no = no;
    }

    public ClassRoom(List<Student1> student1s) {
        this.student1s = student1s;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public List<Student1> getStudent1s() {
        return student1s;
    }

    public void setStudent1s(List<Student1> student1s) {
        this.student1s = student1s;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "no='" + no + '\'' +
                ", student1s=" + student1s +
                '}';
    }
}

/**
 * 学生类
 */
class Student1{
    private String name;
    private String no;
    private double score;
    private ClassRoom classRoom;//一个学生对应一个班级

    public Student1(String name, String no, double score) {
        this.name = name;
        this.no = no;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Student1() {
    }

    @Override
    public String toString() {
        return "Student1{" +
                "name='" + name + '\'' +
                ", no='" + no + '\'' +
                ", score=" + score +
                '}';
    }
}