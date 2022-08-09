package com.lifeng.java.day27.exer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 练习5：上传文件服务器给出反馈
 * -----接收端(管道输入流得到文件后写出到本地，然后做出反馈)
 * @author lifeng
 * @create 2022-07-26 18:50
 */
public class exer8 {
    public static void main(String[] args) throws Exception{
        //1.创建ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(8888);
        //2.监听连接
        Socket accept = serverSocket.accept();
        //3.创建管道输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new FileWriter("c.txt"));
        //4.处理数据，做出反馈
        String data = null;
        while ((data = br.readLine()) != null){
            bw.write(data);
            bw.newLine();
            bw.flush();
        }

        bw.close();//关闭写入流

        //反馈
        String message = "我已经收到全部的数据了！";
        BufferedWriter bww = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
        bww.write(message);
        bww.flush();
        bww.close();

        //5.关闭流资源
        accept.close();
        serverSocket.close();

    }
}
