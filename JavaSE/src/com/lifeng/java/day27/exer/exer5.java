package com.lifeng.java.day27.exer;

import java.io.BufferedOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 练习3：服务器数据写入文本文件
 * -----发送端
 * @author lifeng
 * @create 2022-07-26 18:50
 */
public class exer5 {
    public static void main(String[] args) throws Exception{
        //1.创建Socket对象
        Socket socket = new Socket("127.0.0.1", 8888);
        //2.创建键盘输入流，接收数据
        System.out.println("请持续录入数据(输入886结束)");
        Scanner scanner = new Scanner(System.in);
        while (true){
            String next = scanner.next();//接收键盘录入的数据

            if ("886".equals(next)){
                break;//跳出循环
            }

            //3.创建管道输出流对象
            BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
            //4.输出数据
            bos.write(next.getBytes());
            bos.flush();//刷新
        }

        //5.关闭资源
        socket.close();
    }
}
