package com.lifeng.java.day26.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

//用户
public class SendDemo02 {
	public static void main(String[] args) throws IOException {
		//创建Socket对象
		DatagramSocket ds = new DatagramSocket();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			//创建数据
			String data = sc.next();
			
			//创建数据报包对象，封装数据
			DatagramPacket dp = new DatagramPacket(data.getBytes(), data.getBytes().length,
					InetAddress.getByName("192.168.16.145"), 12306);
			
			//发送数据报包对象
			ds.send(dp);
			
			//判断什么时候退出
			if("886".equals(data)) {
				break;
			}
		}
		
		//释放资源
		ds.close();
	}
}
