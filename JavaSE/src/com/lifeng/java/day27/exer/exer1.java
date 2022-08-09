package com.lifeng.java.day27.exer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *练习1：服务器给出反馈
 * -----发送端
 * @author lifeng
 * @create 2022-07-26 18:49
 */
public class exer1 {
    public static void main(String[] args) throws Exception{
        //1.创建Socket对象
        Socket socket = new Socket("127.0.0.1",8888);
        //2.创建要发送的数据
        String s = "我把数据发送给你了！";
        //3.创建管道流
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        //4.用管道流发送数据
        bos.write(s.getBytes());
        bos.flush();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(br.readLine());

        //5.关闭资源
        socket.close();

    }
}
