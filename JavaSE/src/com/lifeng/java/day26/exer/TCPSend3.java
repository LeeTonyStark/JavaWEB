package com.lifeng.java.day26.exer;

import com.lifeng.java.day26.pojo.Employee;

import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author lifeng
 * @create 2022-07-25 23:01
 */
public class TCPSend3 {
    public static void main(String[] args) throws Exception{
        //1.创建Secket对象
        Socket socket = new Socket("192.168.0.119", 10086);

        //2.创建数据
        Employee employee = new Employee("佩奇", 22, "001");

        //3.创建管道输出流对象(使用对象输出流)
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

        //4.发送数据
        oos.writeObject(employee);
        oos.flush();

        //5.关闭资源
        socket.close();
    }
}
