package com.lifeng.java.day26.demo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * UDP协议下的发送端
 * @author lifeng
 * @create 2022-07-25 11:26
 */
public class UDPSendTest {
    public static void main(String[] args) throws Exception {
        //1.创建Socket对象
        DatagramSocket datagramSocket = new DatagramSocket(10087);

        //2.创建数据报包对象
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length);

        //3.接收数据报包对象
        datagramSocket.receive(dp);

        //4.解析
        String ip = dp.getAddress().getHostAddress();
        String date = new String(bytes, 0, dp.getLength());

        System.out.println(ip + "..." + date);

        //5.释放资源
        datagramSocket.close();


    }
}
