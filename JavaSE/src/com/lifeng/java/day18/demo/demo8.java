package com.lifeng.java.day18.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 3、在一个列表中存储以下元素：apple,grape,banana,pear
 * • 3.1 返回集合中的最大的和最小的元素
 * • 3.2 将集合进行排序，并将排序后的结果打印在控制台上
 * @author lifeng
 * @create 2022-07-13 14:49
 */
public class demo8 {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("apple");
        list.add("grape");
        list.add("banana");
        list.add("pear");

        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("********排序后：**********");

        for (Object o : paiXu(list)) {
            System.out.println(o);
        }

        System.out.println("******最大值：********");
        System.out.println(paiXu(list).get(list.size() - 1));
        System.out.println("******最小值：********");
        System.out.println(paiXu(list).get(0));

    }
    
    public static List paiXu(List<String> list){
        String temp = "";//作为交换的容器
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() -1 - i; j++) {
                if (list.get(j).compareTo(list.get(j+1)) > 0){
                    temp=list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temp);
                }
            }
        }
        return list;
    }
}
