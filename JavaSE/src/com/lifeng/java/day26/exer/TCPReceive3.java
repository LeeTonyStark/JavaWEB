package com.lifeng.java.day26.exer;

import com.lifeng.java.day26.pojo.Employee;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lifeng
 * @create 2022-07-25 23:02
 */
public class TCPReceive3 {
    public static void main(String[] args) throws Exception{
        //1.创建ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(10086);

        //2.监听连接
        Socket accept = serverSocket.accept();

        //3.创建管道输入流对象(使用对象输入流)
        ObjectInputStream ois = new ObjectInputStream(accept.getInputStream());

        //4.处理数据接收数据
        Employee employee = (Employee) ois.readObject();
        System.out.println(employee);

        //5.关闭资源
        serverSocket.close();
    }
}
