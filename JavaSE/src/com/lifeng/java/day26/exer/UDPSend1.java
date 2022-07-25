package com.lifeng.java.day26.exer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.Scanner;

/**
 * UDP协议特点：
 *  1.面向无连接
 *  2.传输速度相对较快
 *  3.相对不安全，数据容易丢失
 *
 *  模拟聊天室聊天功能
 * @athor lifeng
 * @create 2022-07-25 22:02
 */
public class UDPSend1 {
    public static void main(String[] args) throws IOException {

        //1.创建Socket对象
        DatagramSocket ds = new DatagramSocket();

        while (true){
            //2.创建数据
            Scanner scanner = new Scanner(System.in);
            String s = scanner.next();

            //3.创建数据报包对象，将数据封装到里面
            DatagramPacket dp = new DatagramPacket(s.getBytes(), s.getBytes().length, InetAddress.getByName("192.168.0.119"), 10086);

            //4.发送集装箱
            ds.send(dp);

            if ("886".equals(s)){
                break;
            }

        }

        //5.释放资源
        ds.close();
    }
}
