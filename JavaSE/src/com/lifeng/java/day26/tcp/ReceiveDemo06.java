package com.lifeng.java.day26.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceiveDemo06 {
	public static void main(String[] args) throws Exception {
		//创建Socket对象
		ServerSocket ss = new ServerSocket(12306);
		
		//监听连接
		Socket s = ss.accept();
		
		//获取管道输入流对象
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		//读取数据
		String data = br.readLine();
		System.out.println(data);
		
		//写出反馈信息
		//获取管道输出流对象
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
	
		//写出数据
		bw.write("不约");
		bw.flush();
		
		//释放资源
		s.close();
		ss.close();
		
	}
}
