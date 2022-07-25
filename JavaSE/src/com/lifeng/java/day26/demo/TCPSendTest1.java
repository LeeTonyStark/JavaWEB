package com.lifeng.java.day26.demo;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * 模拟TCP发送数据
 * @author lifeng
 * @create 2022-07-25 15:01
 */
public class TCPSendTest1 {
    public static void main(String[] args) throws Exception{

        //1.创建Socket对象
        Socket socket = new Socket("192.168.0.119",10086);

        //2.创建数据
        Pig pig = new Pig("佩奇","女",22);
        String data = pig.toString();

        //3.获取管道输出流对象
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        //4.写出数据
        bw.write(data);
        bw.flush();

        //5.释放资源
        socket.close();
    }
}

class Pig{
    private String name;
    private String sex;
    private Integer age;

    public Pig() {
    }

    public Pig(String name, String sex, Integer age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pig{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}