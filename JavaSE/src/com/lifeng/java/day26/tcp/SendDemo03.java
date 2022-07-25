package com.lifeng.java.day26.tcp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SendDemo03 {
	public static void main(String[] args) throws IOException {
		//1.创建Socket对象
		Socket s = new Socket("192.168.16.145", 12306);
		
		//2.创建数据
		String data = "约吗";
		
		//3.获取管道输出流对象
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		
		//4.写出数据
		bw.write(data);
		
		//刷新
		bw.flush();
		
		//5.释放资源
		s.close();
	}
}
