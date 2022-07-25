package com.lifeng.java.day26.tcp;

import com.lifeng.java.day26.pojo.Pig;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceiveDemo04 {
	public static void main(String[] args) throws Exception {
		//1.创建Socket对象
		ServerSocket ss = new ServerSocket(12306);
		
		//2.监听连接
		Socket s = ss.accept();
		
		//3.获取管道输入流对象
		ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
		
		//4.读取数据
		Pig pig = (Pig)ois.readObject();
		System.out.println(pig);
		
		//5.释放资源
		s.close();
		ss.close();
	}
}
