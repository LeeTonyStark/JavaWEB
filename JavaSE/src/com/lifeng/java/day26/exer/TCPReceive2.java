package com.lifeng.java.day26.exer;

import java.io.BufferedInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lifeng
 * @create 2022-07-25 22:49
 */
public class TCPReceive2 {
    public static void main(String[] args) throws Exception{
        //1.创建ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(10086);

        //2.使用accept监听数据
        Socket accept = serverSocket.accept();

        //3.创建管道输入流对象(使用缓冲流加快TCP数据传输)
        BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());

        //4.接收数据
        byte[] bytes = new byte[1024];
        int read = bis.read(bytes);
        String s = new String(bytes, 0, read);
        System.out.println(s);

        //5.关闭资源
        accept.close();
        serverSocket.close();
    }
}
