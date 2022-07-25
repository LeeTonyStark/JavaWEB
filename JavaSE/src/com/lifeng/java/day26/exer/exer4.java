package com.lifeng.java.day26.exer;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 练习2：客户端数据来自键盘录入
 * 	客户端持续键盘录入，服务器端只需要打印，不需要反馈
 * 	-------接收端
 * @author lifeng
 * @create 2022-07-25 23:34
 */
public class exer4 {
    public static void main(String[] args) throws Exception{
        //1.创建ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true){
            //2.监听连接
            Socket accept = serverSocket.accept();
            //3.创建管道输入流对象
            InputStream is = accept.getInputStream();
            //4.接收数据
            byte[] bytes = new byte[1024];
            int read = is.read(bytes);
            String s = new String(bytes, 0, read);
            System.out.println(s);
        }
        //5.关闭资源
//        accept.close();
//        serverSocket.close();
    }
}
