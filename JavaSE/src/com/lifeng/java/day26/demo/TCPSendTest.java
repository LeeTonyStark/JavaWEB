package com.lifeng.java.day26.demo;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 模拟TCP发送数据
 * @author lifeng
 * @create 2022-07-25 15:01
 */
public class TCPSendTest {
    public static void main(String[] args) throws Exception{

        //1.创建Socket对象
        Socket socket = new Socket("192.168.0.119",10086);

        //2.创建数据
        String data = "TCP数据";

        //3.获取管道输出流对象
//        OutputStream os = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        //4.写出数据
        bos.write(data.getBytes());
        bos.flush();

        //5.释放资源
        socket.close();
    }
}
