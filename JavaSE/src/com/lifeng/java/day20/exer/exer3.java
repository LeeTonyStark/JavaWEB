package com.lifeng.java.day20.exer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 3.打印出指定的文件夹aaa中的所有以.java为后缀名文件的绝对路径？
 * 	-- aaa
 * 		-- bbb
 * 			-- ccc
 * 				-- ccc.java
 * 			-- bbb.java
 * 			-- bbb.txt
 * 		-- aaa.txt
 * 		-- aaa.java
 * 		-- aaa.jpg
 *
 * @author lifeng
 * @create 2022-07-16 10:08
 */
public class exer3 {
    public static void main(String[] args) {
        File file = new File("aaa");
        List<String> list = new ArrayList<String>();//存储所有.java路径
        for (File listFile : file.listFiles()) {
            if (listFile.getName().contains(".java")) {
                list.add(listFile.getAbsolutePath());
            }
            if (listFile.isDirectory()){
                File[] files = listFile.listFiles();
                for (File file1 : files) {
                    if (file1.getName().contains(".java")) {
                        list.add(file1.getAbsolutePath());
                    }
                    if (file1.isDirectory()){
                        File[] files1 = file1.listFiles();
                        for (File file2 : files1) {
                            if (file2.getName().contains(".java")) {
                                list.add(file2.getAbsolutePath());
                            }
                        }
                    }
                }
            }
        }

        for (String s : list) {
            System.out.println(s);
        }
    }
}
