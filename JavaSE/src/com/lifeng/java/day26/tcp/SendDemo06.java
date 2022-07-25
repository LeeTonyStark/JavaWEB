package com.lifeng.java.day26.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SendDemo06 {
	public static void main(String[] args) throws Exception {
		//创建Socket对象
		Socket s = new Socket("192.168.16.145", 12306);
		
		//创建数据
		String data = "约吗";
		
		//获取管道输出流对象
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		
		//写出数据
		bw.write(data);
		//bw.newLine();
		bw.flush();
		
		//读取反馈信息
		//获取管道输入流对象
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		//读取数据
		String message = br.readLine();
		System.out.println(message);
		
		//释放资源
		s.close();
	}
}
