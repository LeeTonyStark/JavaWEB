package com.lifeng.java.day26.exer;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 练习5：上传文件服务器给出反馈
 * -----接收端
 * @author lifeng
 * @create 2022-07-26 1:05
 */
public class exer10 {
    public static void main(String[] args) throws Exception{
        //1.创建ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(8888);
        BufferedReader br = null;
        Socket accept = null;
        //2.监听连接
        while (true){
            accept = serverSocket.accept();
            //3.创建管道输入流对象
            br = new BufferedReader(new InputStreamReader(accept.getInputStream(),"utf-8"));
            //4.处理数据展示
            String s = br.readLine();
            System.out.println(s);
            break;
        }

        //若已经接收到最后一个数据，给发送端做出一个反馈
        String s1 = "数据已经收到";
        OutputStream os = accept.getOutputStream();
        os.write(s1.getBytes());

        //5.关闭资源
        accept.close();
        serverSocket.close();
    }
}
