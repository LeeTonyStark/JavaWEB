package com.lifeng.java.day21.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author lifeng
 * @create 2022-07-18 16:40
 */
public class demo9 {
    public static void main(String[] args) {
        FileInputStream fis = null;

        FileOutputStream fos = null;

        try{
            fis = new FileInputStream("aaa.txt");

            fos = new FileOutputStream("ccc.txt");

            byte[] bys = new byte[5];
            int len = 0;
            while((len = fis.read(bys)) != -1){
                fos.write(bys,0,len);
            }
        }catch(Exception e){
            System.out.println("复制文件有错误");
        }finally{
            if(fis != null){
                try{
                    fis.close();
                }catch(Exception e){}
            }
            if(fos != null){
                try{
                    fos.close();
                }catch(Exception e){}
            }
        }

    }
}
