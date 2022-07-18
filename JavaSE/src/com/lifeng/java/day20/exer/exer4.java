package com.lifeng.java.day20.exer;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 4.统计一个文件夹中每种文件的个数并打印(文件夹路径下没有子文件夹)
 * 	打印格式如下：
 * 		txt:3个
 * 		doc:4个
 * 		jpg:6个
 * @author lifeng
 * @create 2022-07-16 10:24
 */
public class exer4 {
    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();
        File file = new File("aaa");
        for (File listFile : file.listFiles()) {
            if (listFile.isFile()) {
                String[] split = listFile.getName().split("\\.");
                if (map.containsKey(split[1])){
                    int Count = map.get(split[1]);
                    Count++;
                    map.put(split[1],Count);
                }else {
                    map.put(split[1],1);
                }
            }
        }


        Set<Map.Entry<String, Integer>> set = map.entrySet();
        for (Map.Entry<String, Integer> entry : set) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + ":" +value + "个");
        }

    }
}
