package com.lifeng.java.day26.exer;


import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP协议的特点？
 *  1.面向有连接
 *  2.传输速度相对较慢
 *  3.相对安全
 * @author lifeng
 * @create 2022-07-25 22:28
 */
public class TCPReceice1 {
    public static void main(String[] args) throws Exception{
        //1.创建Scoket对象
        ServerSocket serverSocket = new ServerSocket(10087);

        //2.监听连接
        Socket accept = serverSocket.accept();

        //3.获取管道输入流对象
        InputStream is = accept.getInputStream();

        //4.读取数据,一次读取1024个字节
        byte[] bytes = new byte[1024];
        int read = is.read(bytes);
        //将数据改为String
        String s = new String(bytes, 0, read);
        System.out.println(s);

        //5.释放资源
        serverSocket.close();
        accept.close();
    }
}
