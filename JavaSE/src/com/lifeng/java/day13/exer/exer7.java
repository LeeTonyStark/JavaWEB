package com.lifeng.java.day13.exer;

/**
 *
 4.分析以下需求，并用代码实现：
 (1)定义数字字符串数组{"010","3223","666","7890987","123123"}
 (2)判断该数字字符串数组中的数字字符串是否是对称(第一个数字和最后一个数字相等，
 第二个数字和倒数第二个数字是相等的，依次类推)的，并逐个输出
 (3)如：010 是对称的，3223 是对称的，123123 不是对称的
 * @author lifeng
 * @create 2022-07-06 19:19
 */
public class exer7 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] arr = {"010","3223","666","7890987","123123"};
        for (int i = 0; i < arr.length; i++) {
            stringBuilder = new StringBuilder(arr[i]);
            if (stringBuilder.reverse().toString().equals(arr[i])){
                System.out.print("对称："+arr[i]);
            }
            System.out.println();
        }
    }
}
