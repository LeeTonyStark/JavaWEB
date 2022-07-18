package com.lifeng.java.day13.exer;

/**
 * 2.分析以下需求，并用代码实现：
 * 	(1)键盘录入一个小数，要求小数点后的小数位最少2位
 * 	(2)定义方法，实现保留小数点后的两位小数(只舍不进)
 * 	(3)如：输入5.6789 输出5.67,输入5.67389 输出5.67
 * @author lifeng
 * @create 2022-07-06 18:42
 */
public class exer5 {
    public static void main(String[] args) {

        String s = exer5.mySubString(123.1415926);
        System.out.println(s);

    }
    public static String mySubString(double d1){
        char a = '.';
        String s = String.valueOf(d1);
        //取到所输入小数的小数点的索引
        int i = s.indexOf(a);
        String substring = s.substring(0, i+3);

        return substring;
    }

}
