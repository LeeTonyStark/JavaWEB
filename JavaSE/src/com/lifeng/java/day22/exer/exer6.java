package com.lifeng.java.day22.exer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**

 6.项目根路径下有text.txt文件，内容如下：
 我爱Java
 123456
 利用IO流的知识读取text.txt文件的内容反转后写入text.txt文件中，内容如下：
 123456
 我爱Java

 * @author lifeng
 * @create 2022-07-20 0:39
 */
public class exer6 {
    public static void main(String[] args) throws Exception{

        ArrayList<String> list = new ArrayList<>();//存储text.txt文件的数据

        BufferedReader br = new BufferedReader(new FileReader("text.txt"));

        String s = "";
        while ((s = br.readLine()) != null){
            list.add(s);
        }

        br.close();//关流


        BufferedWriter bw = new BufferedWriter(new FileWriter("text.txt"));
        //遍历list集合，将数据覆盖存储到text.txt中

        Object[] objects = list.toArray();
        for (int i = objects.length - 1; i >= 0; i--) {
            bw.write((String)objects[i] + "\n");
            bw.flush();//刷新
        }

        bw.close();

    }
}
