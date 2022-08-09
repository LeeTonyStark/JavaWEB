package com.lifeng.java.day27.exer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 练习3：服务器数据写入文本文件
 * -----接收端
 * @author lifeng
 * @create 2022-07-26 18:50
 */
public class exer6 {
    public static void main(String[] args) throws Exception{
        //1.创建ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(8888);

        //2.监听连接
        Socket accept = serverSocket.accept();
        //3.创建管道输入流对象
        BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
        //4.接收处理数据

        byte[] bytes = new byte[1024];
        int read = 0;
        File file = new File("b.txt");
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
        while ((read = bis.read(bytes)) != -1){
            String s = new String(bytes, 0, read);
            bos.write((s+"\r\n").getBytes());//写入数据到文件
            bos.flush();//刷新缓冲区数据到硬盘
            System.out.println(s);
        }

        //5.关闭资源
        bos.close();
        accept.close();
        serverSocket.close();
    }
}
