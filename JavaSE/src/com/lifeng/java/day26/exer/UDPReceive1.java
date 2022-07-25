package com.lifeng.java.day26.exer;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP接收端报包对象
 * 模拟聊天室聊天功能
 * @author lifeng
 * @create 2022-07-25 22:03
 */
public class UDPReceive1 {
    public static void main(String[] args) throws Exception{

        //1.创建Socket对象
        DatagramSocket ds = new DatagramSocket(10086);


        while (true){
            //2.创建数据报包对象
            byte[] bytes = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length);

            //3.接收数据报包对象
            ds.receive(dp);

            //4.解析
            String ip = dp.getAddress().getHostAddress();
            String data = new String(dp.getData(), 0, dp.getLength());
            System.out.println(ip + "..." + data);
        }


        //5.释放资源
//        ds.close();

    }
}
