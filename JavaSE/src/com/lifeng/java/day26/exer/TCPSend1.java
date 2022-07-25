package com.lifeng.java.day26.exer;


import java.io.OutputStream;
import java.net.Socket;

/**
 * @author lifeng
 * @create 2022-07-25 22:28
 */
public class TCPSend1 {
    public static void main(String[] args) throws Exception{

        //1.创建Socket对象
        Socket socket = new Socket("192.168.0.119", 10087);
        //2.创建数据
        String s = "我是TCP传输的协议";

        //3.获取管道输出流对象
        OutputStream os = socket.getOutputStream();

        //4.写出数据
        os.write(s.getBytes());

        //5.释放资源
        socket.close();
    }
}
