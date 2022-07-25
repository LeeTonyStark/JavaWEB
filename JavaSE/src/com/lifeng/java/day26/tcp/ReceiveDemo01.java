package com.lifeng.java.day26.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceiveDemo01 {
	public static void main(String[] args) throws IOException {
		//1.创建Socket对象
		ServerSocket ss = new ServerSocket(12306);
		
		//2.监听连接
		Socket s = ss.accept();
		
		//3.获取管道输入流对象
		InputStream is = s.getInputStream();
		
		//4.读取数据
		byte[] bys = new byte[1024];
		int len = is.read(bys);
		String data = new String(bys, 0, len);
		System.out.println(data);
		
		//5.释放资源
		s.close();
		ss.close();
	}
}
