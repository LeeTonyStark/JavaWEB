package com.lifeng.java.day26.exer;

import java.io.*;
import java.net.Socket;

/**
 * 练习4：客户端数据来自于文本文件(上传文件)
 * ------发送端
 * @author lifeng
 * @create 2022-07-26 0:27
 */
public class exer7 {
    public static void main(String[] args) throws Exception{
        //1.创建Socket对象
        Socket socket = new Socket("192.168.0.119", 8888);
        //2.创建要发送的数据
        File file = new File("a.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));//读取本地txt文件
        BufferedWriter os = null;
        while (true){
            //3.创建管道流对象
            os = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"));
            //4.发送数据
            String s = br.readLine();
            if (s==null){
                break;
            }
            os.write(s);
            os.flush();
        }

        //5.关闭资源
        socket.close();
    }
}
