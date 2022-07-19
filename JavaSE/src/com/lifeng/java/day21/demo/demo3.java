package com.lifeng.java.day21.demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author lifeng
 * @create 2022-07-18 14:13
 */
public class demo3 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("aaa.txt", true);
        fos.write('a');
        fos.write('a');
        fos.write('a');
        fos.write('a');
//        fos.write('\n');
        fos.write('/');
        fos.write('a');
        fos.write('a');
        fos.write('a');
        fos.write('d');


    }
}
