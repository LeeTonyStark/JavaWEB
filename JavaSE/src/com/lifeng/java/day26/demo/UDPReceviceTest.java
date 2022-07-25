package com.lifeng.java.day26.demo;

import java.io.IOException;
import java.net.*;

/**
 * UDP协议下的接收端
 * @author lifeng
 * @create 2022-07-25 11:26
 */
public class UDPReceviceTest {
    public static void main(String[] args) throws IOException {
        //1.创建Socket对象
        DatagramSocket socket = new DatagramSocket();

        //2.创建数据
        String data = "你好Socket";

        //3.创建数据报包对象，将数据封装到里面
        DatagramPacket dp = new DatagramPacket(data.getBytes(),data.getBytes().length, InetAddress.getByName("192.167.0.119"),10087);

        //4.发送到集装箱
        socket.send(dp);

        //5.释放资源(关闭Socket对象)
        socket.close();
    }
}
