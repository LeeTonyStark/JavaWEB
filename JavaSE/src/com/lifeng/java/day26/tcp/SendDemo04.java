package com.lifeng.java.day26.tcp;

import com.lifeng.java.day26.pojo.Pig;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;



public class SendDemo04 {
	public static void main(String[] args) throws IOException {
		//1.创建Socket对象
		Socket s = new Socket("192.168.16.145", 12306);
		
		//2.创建数据
		Pig pig = new Pig("tom", 18);
		
		//3.获取管道输出流对象
		ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
		
		//4.写出数据
		oos.writeObject(pig);
		
		//5.释放资源
		s.close();
	}
}
