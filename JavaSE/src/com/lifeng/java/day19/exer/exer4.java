package com.lifeng.java.day19.exer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 4.分析以下需求，并用代码实现：
 * 	(1)统计每个单词出现的次数
 * 	(2)有如下字符串"If you want to change your fate I think you must come to the woniu to learn java"
 * 	(3)打印格式：
 * 		to=3
 *   		think=1
 *   		you=2
 *   		//........
 * @author lifeng
 * @create 2022-07-14 20:14
 */
public class exer4 {
    public static void main(String[] args) {
        String s = "If you want to change your fate I think you must come to the woniu to learn java";
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        String[] split = s.split(" ");

        for (int i = 0; i < split.length; i++) {
            if (treeMap.containsKey(split[i])){
                treeMap.put(split[i],treeMap.get(split[i])+1);
            }else {
                treeMap.put(split[i],1);
            }
        }

        Set<Map.Entry<String,Integer>> set = treeMap.entrySet();
        for(Map.Entry<String,Integer> entry : set){
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key+"="+value);
        }
    }
}
