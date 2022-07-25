package com.lifeng.java.day26.exer;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 练习2：客户端数据来自键盘录入
 * 	客户端持续键盘录入，服务器端只需要打印，不需要反馈
 * 	-------发送端
 * @author lifeng
 * @create 2022-07-25 23:34
 */
public class exer3 {
    public static void main(String[] args) throws Exception{
        //1.创建Socket对象
        Socket socket = new Socket("192.168.0.119", 8888);
        //2.创建键盘录入对象接收数据
        Scanner scanner = new Scanner(System.in);

        while (true){
            String next = scanner.next();
            //3.创建管道输出流对象
            OutputStream os = socket.getOutputStream();
            //4.发送数据
            os.write(next.getBytes());

            if ("886".equals(next)){
                break;
            }
        }

        //5.关闭资源
        socket.close();
    }
}
