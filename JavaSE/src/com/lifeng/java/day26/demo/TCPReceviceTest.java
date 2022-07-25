package com.lifeng.java.day26.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lifeng
 * @create 2022-07-25 15:02
 */
public class TCPReceviceTest {
    public static void main(String[] args) throws Exception {
        //1.创建Socket对象
        ServerSocket socket = new ServerSocket(10086);

        //2.监听连接
        Socket accept = socket.accept();

        //3.获取管道输入流对象
//        InputStream is = accept.getInputStream();
        BufferedInputStream bos = new BufferedInputStream(accept.getInputStream());

        //4.读取数据
        byte[] bytes = new byte[1024];
        int len = bos.read(bytes);
        String s = new String(bytes, 0, len);
        System.out.println(s);


        //5.释放资源
        socket.close();
        accept.close();
    }
}
