package com.lifeng.java.day26.exer;

import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 * TCP：
 * 练习1：服务器给出反馈
 * -------发送端
 * @author lifeng
 * @create 2022-07-25 22:02
 */
public class exer1 {
    public static void main(String[] args) throws Exception{
        //1.创建Socket对象
        Socket socket = new Socket("192.168.0.119", 8888);
        //2.创建要发送的数据
        String s = "最近过的还好吗？";
        //3.创建管道输出流对象
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        //4.发送数据，并且创建管道输入流对象接收反馈
        bos.write(s.getBytes());
        bos.flush();//刷新
        //创建管道输入流对象接收反馈
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int read = is.read(bytes);
        String s1 = new String(bytes, 0, read);
        System.out.println(s1);

        //5.关闭流资源
        socket.close();
    }
}
