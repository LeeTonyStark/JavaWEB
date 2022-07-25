package com.lifeng.java.day26.demo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 接收端
 * @author lifeng
 * @create 2022-07-25 15:02
 */
public class TCPReceviceTest2 {
    public static void main(String[] args) throws Exception {
        //1.创建SocketServer对象
        ServerSocket serverSocket = new ServerSocket(10086);

        //2.监听连接
        Socket accept = serverSocket.accept();

        //3.获取管道输入流对象
        InputStream is = accept.getInputStream();

        //4.读取数据
        byte[] bytes = new byte[1024];
        int read = is.read(bytes);
        //将读取的数据转换为数组
        String s = new String(bytes, 0, read);
        System.out.println(s);

        //5.释放资源
        serverSocket.close();
        accept.close();
    }
}
