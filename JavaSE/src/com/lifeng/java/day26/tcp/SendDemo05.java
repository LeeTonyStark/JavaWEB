package com.lifeng.java.day26.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SendDemo05 {
	public static void main(String[] args) throws Exception {
		//创建Socket对象
		Socket s = new Socket("192.168.16.145", 12306);
		
		//创建数据
		String data = "约吗";
		
		//获取管道输出流对象
		OutputStream os = s.getOutputStream();
		
		//写出数据
		os.write(data.getBytes());
		
		//读取反馈信息
		//获取管道输入流对象
		InputStream is = s.getInputStream();
		
		//读取数据
		byte[] bys = new byte[1024];
		int len = is.read(bys);
		String message = new String(bys, 0, len);
		System.out.println(message);
		
		//释放资源
		s.close();
	}
}
