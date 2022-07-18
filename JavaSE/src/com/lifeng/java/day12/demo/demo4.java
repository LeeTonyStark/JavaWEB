package com.lifeng.java.day12.demo;

/**
 * String 常用方法的练习
 * @author lifeng
 * @create 2022-07-05 16:38
 */
public class demo4 {
    public static void main(String[] args) {

        //charAt(int index):返回字符串索引位置的值
        System.out.println("abcdefffff".charAt(7));//f

        //compareTo：返回s1距s2的字典值
        String s1 = "abc";
        String s2 = "ope";
        System.out.println(s1.compareTo(s2));//-14

        //concat:连接指定字符串至结尾
        System.out.println(s1.concat(s2));//acbope

        //contains:判断调用者是否有xxx字符串
        System.out.println(s1.contains(s2));//false
        System.out.println(s1.contains("a"));//true

        //endWith:判断调用者是否以xxx结尾
        System.out.println(s1.endsWith("c"));//true

        //equalsIgnoreCase:判断两个字符串是否相同，不区分大小写
        System.out.println(s1.equalsIgnoreCase(s2));//false
        System.out.println(s1.equalsIgnoreCase("abc"));//true

        //getBytes:将字符串转换为字节数组
        byte[] bytes = s1.getBytes();
        for (int i = 0;i < bytes.length;i++){
            System.out.print(bytes[i]);//97 98 99
        }
        System.out.println();

        //indexOf():返回xxx在字符串中首次出现的索引
        System.out.println(s1.indexOf("a"));//0

        //lastIndexOf():返回xxx在字符串最后出现的索引
        String s3 = new String("qwoqddddfdsfsd");
        System.out.println(s3.lastIndexOf("s"));//12

        //replace:将字符串中的xxx替换，并返回一个新字符串
        String replace = s3.replace("f", "A");
        System.out.println(replace);//qwoqddddAdsAsd

        //split:切片，将字符串中的xxx切掉，返回一个新字符串数组，适用于正则表达式
        String s4 = "a-y-r-h--b---ggg";
        String[] split = s4.split("-");
        for (String s : split) {
            System.out.print(s);//ayrhbggg
        }
        System.out.println();

        //substring:截取字符串
        System.out.println(s4.substring(12));//-ggg

        //toCharArray:将字符串转换为Char型字符数组
        for (char c : s4.toCharArray()) {
            System.out.println(c);//a - y - r - h - - b - - - g g g
        }

        //toUpperCase():将字符串的小写全转换为大写
        System.out.println(s4.toUpperCase());//A-Y-R-H--B---GGG

        //toLowerCase:将字符串大写转换为小写
        String s5 = "  JK GF UFUF JGJ ";
        System.out.println(s5.toLowerCase());//jkgfufufjgj

        System.out.println(s5.trim());//JK GF UFUF JGJ

    }
}
