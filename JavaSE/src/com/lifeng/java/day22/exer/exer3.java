package com.lifeng.java.day22.exer;

import java.io.*;

/**
 * 3.将文件name.txt中的以下数据：
 * 	张三,18,男银
 * 	李四,20,女银
 * 	...
 * 	...
 * 	需求：将文件中李四的名字修改为王五，其他不变
 * @author lifeng
 * @create 2022-07-19 21:26
 */
public class exer3 {
    public static void main(String[] args){
        File file1 = new File("name.txt");
        File file2 = new File("bbb.txt");
        BufferedReader br = null;
        BufferedWriter bw = null;
        BufferedReader br2 = null;
        BufferedWriter bw2 = null;
        try {
            br = new BufferedReader(new FileReader(file1));//读入文件找到李四
            bw = new BufferedWriter(new FileWriter(file2));

            String s = "";
            while ((s = br.readLine()) != null){
                String[] split = s.split(",");
                if (split[0].equals("李四")){
                    String replace = s.replace("李四", "王五");//将李四替换为王五
                    bw.write(replace + "\n");//写入李四
                    bw.flush();//刷新管道，提交缓冲数据
                }else {
                    bw.write(s + "\n");//写入其他数据
                    bw.flush();
                }
            }

        }catch (Exception e){
            System.out.println("发生了异常");
        }finally{
            if (bw != null){
                try {
                    bw.close();
                }catch (Exception e){
                }
            }
            if (br != null){
                try {
                    br.close();
                }catch (Exception e){

                }
            }
        }


        try {
            br2 = new BufferedReader(new FileReader(file2));
            bw2 = new BufferedWriter(new FileWriter(file1));
            String len = "";
            while ((len = br2.readLine()) != null){
                bw2.write(len + "\n");
                bw2.flush();
            }

        }catch (Exception e){

        }finally {
            if (br2 != null){
                try {
                    br2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bw2 != null){
                try {
                    bw2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
