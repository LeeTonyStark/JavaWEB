package com.lifeng.java.day26.exer;

import java.io.*;
import java.net.Socket;

/**
 * 练习5：上传文件服务器给出反馈
 * ------发送端
 * @author lifeng
 * @create 2022-07-26 1:05
 */
public class exer9 {
    public static void main(String[] args) throws Exception{
        //1.创建Socket对象
        Socket socket = new Socket("192.168.0.119", 8888);
        InputStream is = socket.getInputStream();
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

        byte[] bytes = new byte[1024];
        int read = is.read(bytes);
        String s1 = new String(bytes, 0, read);
        System.out.println(s1);

        //5.关闭资源
        socket.close();
    }
}
