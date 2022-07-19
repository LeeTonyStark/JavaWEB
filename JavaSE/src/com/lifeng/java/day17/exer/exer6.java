package com.lifeng.java.day17.exer;

import java.util.TreeSet;

/**
 * 8.分析以下需求，并用代码实现：
 * 	(1)打印一个字符串的全字符组合情况，原始字符串中没有重复字符
 * 	(2)例如:原始字符串是"def"， 打印得到下列所有组合情况：
 * 		"d" "e" "f" "de" "df" "ed" "ef" "fd" "fe" "def" "dfe" "edf" "efd" "fde" "fed"
 * @author lifeng
 * @create 2022-07-12 19:18
 */
public class exer6 {
        static TreeSet<String> strings = new TreeSet<>();//定义一个静态TreeSet存储组合的字符串
    public static void main(String[] args) {
        String s = "def";

        getStr(s,"");
        System.out.println(strings);
    }

    public static void getStr(String s,String n){
        if (s.length() == 1){
            strings.add(s + n);
            return;//只有一个时，装进去直接跳出循环
        }else {
            //截取这个字符串，将截取的值放到TreeSet集合中
            for (int i = 0; i < s.length(); i++) {
                StringBuilder stringBuilder = new StringBuilder(s);
                String substring =  n + stringBuilder.substring(i, i + 1);
                strings.add(substring);
                getStr(stringBuilder.deleteCharAt(i).toString(),substring);
            }
        }
    }






//    public static void getStr(String s,String pre){
//        if(s.length()==1){
//            strings.add(pre+s);
//            return;
//        }else{
//            for (int i = 0; i < s.length(); i++) {
//                StringBuilder sb=new StringBuilder(s);
//                String str=pre+s.substring(i, i+1);
//                strings.add(str);
//                getStr(sb.deleteCharAt(i).toString(),str);
//            }
//        }
//    }
}
