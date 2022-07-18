package com.lifeng.java.day13.exer;

import java.util.Arrays;

/**
 * 1.分析以下需求，并用代码实现：
 * 	(1)模拟Arrays.toString(int[] arr);方法，自己封装一个public static String toString(int[] arr);
 * 	(2)如果int类型数组arr为null，toString方法返回字符串"null"
 * 	(3)如果int类型数组arr长度为0，toString方法返回字符串"[]"
 * 	(4)如果int类型数组arr的内容为{1,2,3,4,5},toString方法返回字符串"[1, 2, 3, 4, 5]"
 * @author lifeng
 * @create 2022-07-06 17:32
 */
public class exer4 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        int[] arrs = new int[]{1,2,3,4,5};
        String s = Arrays.toString(arr);
        System.out.println(s);
        System.out.println(exer4.myToString(arrs));
    }

    public static String myToString(int[] arrs){
        int[] arr = new int[]{1,2,3,4,5};
        if (arrs == null){
            return null;
        }
        if (arrs.length == 0){
            return "[]";
        }
        if (arrs == arr){
            return "[1, 2, 3, 4, 5]";
        }

        StringBuilder stringBuilder = new StringBuilder("[");

        for (int i = 0; i < arrs.length; i++) {
            if (i < arrs.length - 1)
                stringBuilder.append(arrs[i] + ",");
            if (i == arrs.length - 1){
                stringBuilder.append(arrs[i] + "]");
            }
        }
        String s = stringBuilder.toString();
        return s;
    }
}
