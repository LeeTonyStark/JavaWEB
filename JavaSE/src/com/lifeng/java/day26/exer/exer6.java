package com.lifeng.java.day26.exer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 练习3：服务器数据写入文本文件
 * -----接收端
 * @author lifeng
 * @create 2022-07-25 23:45
 */
public class exer6 {
    public static void main(String[] args) throws Exception{
        //1.创建ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(8888);
        //2.监听连接
        Socket accept = serverSocket.accept();
        //3.创建管道输入流对象
        BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream(), "utf-8"));

        //4.处理数据写入到txt文件
        File file = new File("a.txt");
        BufferedWriter bos = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"utf-8"));//创建高效转换流对象输出数据
        String s = null;
        while ((s = br.readLine()) != null){
            bos.write(s);
            bos.newLine();//换行
            bos.flush();//刷新数据到硬盘
        }

        //5.关闭连接
        accept.close();
        serverSocket.close();
    }
}
