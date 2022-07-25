package com.lifeng.java.day26.demo;

import java.io.OutputStream;
import java.net.Socket;

/**
 * 发送端
 * @author lifeng
 * @create 2022-07-25 17:11
 */
public class TCPSendTest2 {
    public static void main(String[] args) throws Exception{

        //1.创建Socket对象
        Socket socket = new Socket("192.168.0.119",10086);

        //2.创建要发送的数据
        String s = "你好！";

        //3.获取管道输出流对象
        OutputStream os = socket.getOutputStream();

        //4.写出数据
        os.write(s.getBytes());

        //5.释放资源
        socket.close();

    }
}
