package com.lifeng.java.day16.exer;

import java.util.ArrayList;

/**
 * 1.请按以下要求编写代码：
 *      1.定义一个只能存储字符串的集合对象；
 *      2.向集合内添加以下数据：
 *          "孙悟空"
 *          "猪八戒"
 *          "沙和尚"
 *          "铁扇公主"
 *      3.不用遍历，直接打印集合
 *      4.获取第四个元素
 *      5.打印一下集合大小
 *      6.删除元素"铁扇公主"
 *      7.删除第3个元素
 *      8.将元素"猪八戒"改为"猪悟能"
 *      9.再次打印集合
 * @author lifeng
 * @create 2022-07-09 14:51
 */
public class exer1 {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("孙悟空");
        arr.add("猪八戒");
        arr.add("沙和尚");
        arr.add("铁扇公主");
        System.out.println(arr);
        String s = arr.get(3);
        System.out.println(s);
        System.out.println(s.length());
        arr.remove(2);
        arr.set(1,"猪悟能");
        System.out.println(arr);
    }
}
