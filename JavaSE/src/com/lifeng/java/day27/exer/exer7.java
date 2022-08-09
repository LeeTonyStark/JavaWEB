package com.lifeng.java.day27.exer;

import java.io.*;
import java.net.Socket;

/**
 * 练习5：上传文件服务器给出反馈
 * -----发送端(读取本地文件，用管道输出流将数据发送给接收端)
 * @author lifeng
 * @create 2022-07-26 18:50
 */
public class exer7 {
    public static void main(String[] args) throws Exception{
        //1.创建Socket对象
        Socket socket = new Socket("127.0.0.1", 8888);
        //2.创建要发送的数据
        BufferedReader br = new BufferedReader(new FileReader("a.txt"));
        //3.创建管道流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        //4.用管道流发送数据
        String data = null;
        while ((data = br.readLine()) != null){
            bw.write(data);//写一行
            bw.newLine();//换行
            bw.flush();//刷新
        }

        //告知接收端我们这边数据传输完毕了
        socket.shutdownOutput();

        br.close();//关闭读取文件的流

        //TODO 接收反馈信息
        BufferedReader brr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(brr.readLine());

        //5.关闭资源
        socket.close();
    }
}
