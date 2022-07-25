package com.lifeng.java.day26.exer;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP：
 * 练习1：服务器给出反馈
 * ------接收端
 * @author lifeng
 * @create 2022-07-25 23:19
 */
public class exer2 {
    public static void main(String[] args) throws Exception{
        //1.创建ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(8888);
        //2.监听连接
        Socket accept = serverSocket.accept();
        //3.创建管道输入流对象
        InputStream is = accept.getInputStream();
        //4.接收数据，并且给出反馈
        byte[] bytes = new byte[1024];
        int read = is.read(bytes);
        String s = new String(bytes, 0, read);
        System.out.println(s);

        //做出反馈
        String s1 = "我很好";
        OutputStream os = accept.getOutputStream();
        os.write(s1.getBytes());
        //5.关闭资源
        accept.close();
        serverSocket.close();
    }
}
