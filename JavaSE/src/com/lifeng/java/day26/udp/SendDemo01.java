package com.lifeng.java.day26.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendDemo01 {
	public static void main(String[] args) throws Exception {
		//1.创建Socket对象
		DatagramSocket ds = new DatagramSocket();
		
		//2.创建数据
		String data = "约吗";
		
		//3.创建数据报包对象，将数据封装到里面
		DatagramPacket dp = new DatagramPacket(data.getBytes(), data.getBytes().length, InetAddress.getByName("192.168.16.145"), 10086);
		
		//4.发送集装箱
		ds.send(dp);
		
		//5.释放资源(关闭Socket对象)
		ds.close();
	}
}
