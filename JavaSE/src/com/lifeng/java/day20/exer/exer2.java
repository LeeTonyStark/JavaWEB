package com.lifeng.java.day20.exer;

import java.io.File;

/**
 * 2.删除指定文件夹aaa(文件夹中是有子文件和子文件夹的)
 * 	-- aaa
 * 		-- bbb
 * 			-- bbb.txt
 * 			-- bbb.java
 * 			-- ccc
 * 				-- ccc.txt
 * 				-- ccc.jpg
 * 		-- aaa.txt
 * 		-- 1.jpg
 *
 * @author lifeng
 * @create 2022-07-16 9:29
 */
public class exer2 {
    public static void main(String[] args) {
        File file = new File("aaa");

        File[] files = file.listFiles();
        for (File file1 : files) {
            //获取aaa路径下的子目录,如果删除失败就判断该目录是否还有子文件，继续执行删除
            if (!file1.delete()) {
                File[] files1 = file1.listFiles();
                for (File file2 : files1) {
                    if (!file2.delete()) {
                        File[] files2 = file2.listFiles();
                        for (File file3 : files2) {
                            if (!file3.delete()) {
//                                File[] files3 = file3.listFiles();
                                file3.delete();
                            }
                        }
                    }
                }
            }
        }
        file.delete();
    }
}
