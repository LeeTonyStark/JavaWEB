package com.lifeng.java.day26.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ReceiveDemo01 {
	public static void main(String[] args) throws Exception {
		//1.创建Socket对象
		DatagramSocket ds = new DatagramSocket(10086);
		
		//2.创建数据报包对象
		byte[] bys = new byte[1024];
		DatagramPacket dp = new DatagramPacket(bys, bys.length);
		
		//3.接收数据报包对象
		ds.receive(dp);
		
		//4.解析
		String ip = dp.getAddress().getHostAddress();
		//String data = new String(bys, 0, dp.getLength());
		String data = new String(dp.getData(), 0, dp.getLength());
		
		System.out.println(ip + "..." + data);
		
		//5.释放资源
		ds.close();
	}
}
