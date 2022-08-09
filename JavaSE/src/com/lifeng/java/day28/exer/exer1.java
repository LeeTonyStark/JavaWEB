package com.lifeng.java.day28.exer;

import java.io.*;
import java.util.*;

/**
 * 1.分析以下需求，并用代码实现：
 * 	1、生成10个1-15之间的随机数,存储到List集合中(数字不能重复)。
 * 	2、求出List集合中每个元素的阶乘(用递归计算),并对求出的结果进行降序排序
 * 	3、把排序后的数据中不包含3的元素,写入到num.txt文档中。
 * @author lifeng
 * @create 2022-07-27 19:38
 */
public class exer1 {
    public static void main(String[] args) throws IOException {
        HashSet<Integer> integers = new HashSet<>();//存储不重复的随机数
        ArrayList<Integer> list = new ArrayList<>();
        while (integers.size() < 10){
            integers.add((int) (Math.random() * 15) + 1);
        }
        for (Integer integer : integers) {
            list.add(integer);
        }
        System.out.println(list);//将去重后的list集合打印

        TreeSet<Integer> set = new TreeSet<>(new Comparator<Integer>() {//定义一个TreeSet集合存储
            @Override
            public int compare(Integer o1, Integer o2) {

                return o2 - o1;
            }
        });

        for (Integer integer : list) {
            set.add(jieCheng(integer));//将阶乘后的数据装到set集合
        }

        //遍历set集合，将有3的数据去除
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if (next.toString().contains("3")){
                iterator.remove();//使用迭代器将带有3的数据删除
            }
        }

        //创建一个输出流，将set集合中的元素写入到num.txt
        BufferedWriter bw = new BufferedWriter(new FileWriter("num.txt"));

        for (Integer integer : set) {
            String s = new String(String.valueOf(integer));
            bw.write(s);
            bw.newLine();

        }

        bw.close();
        System.out.println("写入完毕！");

    }

    /**
     * 求一个数的阶乘(递归)
     */
    public static Integer jieCheng(Integer num){
        if (num <= 1){
            return 1;
        }
        return num * jieCheng(num-1);
    }


}
