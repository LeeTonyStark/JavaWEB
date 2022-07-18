package com.lifeng.java.day13.exer;

/**
 * 6.定义String getStr(char[] chs)静态方法，方法内要求：获取长度为5的随机字符串，
 * 字符串由随机的4个大写英文字母和1个0-9之间（包含0和9）的整数组成
 * 	定义main方法，方法内完成：
 * 	（1）定义长度为26，元素值为26个大写英文字母的数组chs
 * 	（2）传递数组chs调用getStr(char[] chs)方法，获取返回值,并在控制台打印返回值
 * @author lifeng
 * @create 2022-07-06 20:30
 */
public class exer9 {
    public static void main(String[] args) {

        char[] chs = {'A','B','C','D','E','F','G','H','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

        String str = exer9.getStr(chs);
        System.out.println(str);

    }

    public static String getStr(char[] chs){

        String s = "";
        //0-21的随机数
        int num = (int) (Math.random() * 21);
        //0-9随机数
        int num2 = (int)((Math.random() * 10));
        String s1 = Integer.toString(num2);

        for (int i = 0; i < chs.length; i++) {
            s += chs[i];
        }
        String s3 = s.substring(num, num+4);
        return s3.concat(s1);
    }
}
