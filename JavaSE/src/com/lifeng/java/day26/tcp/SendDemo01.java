package com.lifeng.java.day26.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SendDemo01 {
	public static void main(String[] args) throws IOException {
		//1.创建Socket对象
		Socket s = new Socket("192.168.16.145", 12306);
		
		//2.创建数据
		String data = "约吗";
		
		//3.获取管道输出流对象
		OutputStream os = s.getOutputStream();
		
		//4.写出数据
		os.write(data.getBytes());
		
		//5.释放资源
		s.close();
	}
}
