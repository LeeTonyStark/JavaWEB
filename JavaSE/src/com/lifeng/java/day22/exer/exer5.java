package com.lifeng.java.day22.exer;

import java.io.*;

/**
 5.分析以下需求，并用代码实现
 项目根路径下有个questions.txt文件内容如下：
 5+5
 150-25
 155*155
 2555/5
 要求：读取内容计算出结果，将结果写入到results.txt文件中
 5+5=10
 //....
 * @author lifeng
 * @create 2022-07-20 0:21
 */
public class exer5 {
    public static void main(String[] args) {
        //读取questions.txt文件中的内容
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader("questions.txt"));
            bw = new BufferedWriter(new FileWriter("result.txt"));
            String s = "";
            while ((s = br.readLine()) != null){
                int results = results(s);
                bw.write(s + "=" + results);

                bw.flush();
            }
        }catch (Exception e){

        }finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    //计算结果的方法
    public static int results(String s){
        int result = 0;
        if (s.contains("+")){
            String[] split = s.split("\\+");
            result = Integer.parseInt(split[0]) + Integer.parseInt(split[1]);
        }
        if (s.contains("-")){
            String[] split = s.split("-");
            result = Integer.parseInt(split[0]) - Integer.parseInt(split[1]);
        }
        if (s.contains("*")){
            String[] split = s.split("\\*");
            result = Integer.parseInt(split[0]) * Integer.parseInt(split[1]);
        }
        if (s.contains("/")){
            String[] split = s.split("/");
            result = Integer.parseInt(split[0]) / Integer.parseInt(split[1]);
        }
        return result;
    }
}
