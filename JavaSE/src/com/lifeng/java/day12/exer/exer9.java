package com.lifeng.java.day12.exer;

/**
 * 8.需求：定义一个方法，把int数组中的数据按照指定的格式拼接成一个字符串返回，调用该方法，并在
 * 		控制台输出结果。例如：数组为int[] arr = {1,2,3};,执行方法后的输出结果为：[1,2,3]
 * @author lifeng
 * @create 2022-07-05 21:07
 */
public class exer9 {
    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4,5};

        String s = "";

        for (int i = 0;i < arr.length;i++){
            s += arr[i];
        }
        String concat = "[".concat(s);
        System.out.println(concat.concat("]"));

    }
}
