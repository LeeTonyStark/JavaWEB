package com.lifeng.java.day27.exer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 练习1：服务器给出反馈
 * -----
 * @author lifeng
 * @create 2022-07-26 18:50
 */
public class exer2 {
    public static void main(String[] args) throws Exception{
        //1.创建ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(8888);

        //2.监听连接
        Socket accept = serverSocket.accept();

        //3.创建管道输入流
        BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());

        //4.处理数据，做出反馈
        byte[] bytes = new byte[1024];
        int read = bis.read(bytes);
        String s = new String(bytes, 0, read);
        System.out.println(s);

        //反馈
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
        bw.write("我已经收到数据啦！");
        bw.flush();

        //5.关闭流资源
        bw.close();

        accept.close();
        serverSocket.close();

    }
}
