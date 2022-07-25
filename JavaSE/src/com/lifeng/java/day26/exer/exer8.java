package com.lifeng.java.day26.exer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 练习4：客户端数据来自于文本文件(上传文件)
 * ------接收端
 * @author lifeng
 * @create 2022-07-26 0:27
 */
public class exer8 {
    public static void main(String[] args) throws Exception{
        //1.创建ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(8888);
        //2.监听连接
        while (true){
            Socket accept = serverSocket.accept();
            //3.创建管道输入流对象
            BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream(),"utf-8"));
            //4.处理数据展示
            String s = br.readLine();
            System.out.println(s);
        }


        //5.关闭资源
//        accept.close();
//        serverSocket.close();
    }
}
