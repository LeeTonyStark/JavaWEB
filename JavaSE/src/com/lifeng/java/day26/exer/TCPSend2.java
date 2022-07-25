package com.lifeng.java.day26.exer;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author lifeng
 * @create 2022-07-25 22:48
 */
public class TCPSend2 {
    public static void main(String[] args) throws Exception{
        //1.创建Socket对象
        Socket socket = new Socket("192.168.0.119", 10086);

        //2.传输的数据
        String s = "使用缓冲字节流TCP输出的数据测试";

        //3.创建管道输出流对象(使用缓冲输出流加快传输速度)
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

        //4.发送(输出)数据
        bos.write(s.getBytes());
        bos.flush();//刷新数据

        //5.关闭流
        socket.close();
    }
}
