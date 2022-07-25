package com.lifeng.java.day26.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceiveDemo05 {
	public static void main(String[] args) throws Exception {
		//创建Socket对象
		ServerSocket ss = new ServerSocket(12306);
		
		//监听连接
		Socket s = ss.accept();
		
		//获取管道输入流对象
		InputStream is = s.getInputStream();
		
		//读取数据
		byte[] bys = new byte[1024];
		int len = is.read(bys);
		String data = new String(bys, 0, len);
		System.out.println(data);
		
		//写出反馈信息
		//获取管道输出流对象
		OutputStream os = s.getOutputStream();
	
		//写出数据
		os.write("不约".getBytes());
		
		//释放资源
		s.close();
		ss.close();
		
	}
}
