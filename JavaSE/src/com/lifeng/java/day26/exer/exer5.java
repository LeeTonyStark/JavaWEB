package com.lifeng.java.day26.exer;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 * 练习3：服务器数据写入文本文件
 * ------发送端
 * @author lifeng
 * @create 2022-07-25 23:45
 */
public class exer5 {
    public static void main(String[] args) throws Exception{
        //1.创建Socket对象
        Socket socket = new Socket("192.168.0.119", 8888);
        //2.创建要发送的数据
        ArrayList<String> list = new ArrayList<>();
        list.add("12121213");
        list.add("野猪佩奇");
        list.add("粉色乔治");
        list.add("今晚夜色很美");
//        String s = "123";
        //3.创建管道输出流
        BufferedWriter bos = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"));

        //4.发送数据
        for (String s : list) {
            bos.write(s);
            bos.flush();//刷新
        }
        //5.关闭数据
        socket.close();
    }
}
