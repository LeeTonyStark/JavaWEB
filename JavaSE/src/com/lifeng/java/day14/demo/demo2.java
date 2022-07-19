package com.lifeng.java.day14.demo;

/**
 * 扩展题：
 * 8.分析以下需求，并用代码实现：
 * 	(1)打印由7，8，9三个数组组成的三位数，要求该三位数中任意两位数字不能相同
 * 	(2)打印格式最后的三位数字以空格分隔，如789 798 879 897 978 987
 * @author lifeng
 * @create 2022-07-07 12:15
 */
public class demo2 {
    public static void main(String[] args) {
        char[] arr = {'7','8','9'};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
