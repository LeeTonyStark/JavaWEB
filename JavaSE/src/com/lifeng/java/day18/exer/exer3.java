package com.lifeng.java.day18.exer;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 2.分析以下需求，并用代码实现：
 * 	(1)定义一个TreeSet集合，然后存入6个Double类型的数据，分别是[1.1,5.2,6.3,2.5,5.2,3.3]
 * 	(2)不去重，然后遍历输出(从大到小)
 * @author lifeng
 * @create 2022-07-13 19:52
 */
public class exer3 {
    public static void main(String[] args) {
        TreeSet<Double> dou = new TreeSet<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return o2.compareTo(o1) == 0 ? 1 : o2.compareTo(o1);
            }
        });
        dou.add(1.1);
        dou.add(5.2);
        dou.add(6.3);
        dou.add(2.5);
        dou.add(5.2);
        dou.add(3.3);

        System.out.println(dou);

    }
}
