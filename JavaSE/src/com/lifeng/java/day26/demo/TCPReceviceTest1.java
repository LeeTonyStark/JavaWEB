package com.lifeng.java.day26.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lifeng
 * @create 2022-07-25 15:02
 */
public class TCPReceviceTest1 {
    public static void main(String[] args) throws Exception {
        //1.创建Socket对象
        ServerSocket socket = new ServerSocket(10086);

        //2.监听连接
        Socket accept = socket.accept();

        //3.获取管道输入流对象
        BufferedReader bos = new BufferedReader(new InputStreamReader(accept.getInputStream()));

        //4.读取数据
        String s = bos.readLine();
        System.out.println(s);

        //5.释放资源
        socket.close();
        accept.close();

    }
}
