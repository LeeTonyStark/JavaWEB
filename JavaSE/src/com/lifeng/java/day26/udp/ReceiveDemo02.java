package com.lifeng.java.day26.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveDemo02 {
	public static void main(String[] args) throws IOException {
		//创建Socket对象
		DatagramSocket ds = new DatagramSocket(12306);
		
		while(true) {
			//创建数据报包对象
			byte[] bys = new byte[1024];
			DatagramPacket dp = new DatagramPacket(bys, bys.length);
			
			//接收数据报包
			ds.receive(dp);
			
			//解析
			String ip = dp.getAddress().getHostAddress();
			String data = new String(bys, 0, dp.getLength());
			System.out.println(ip + "..." + data);
		}
		
		//释放资源
		//ds.close();
	}
}
