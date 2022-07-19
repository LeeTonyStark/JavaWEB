package com.lifeng.java.day12.exer;

/**
 * 附加题：将一个字符串的首字母大写，其余全部小写
 * @author lifeng
 * @create 2022-07-05 23:14
 */
public class exer11 {
    public static void main(String[] args) {
        String s = "avbHDKSHSS";
        String s2 = "";
        char c = s.charAt(0);
        char[] chars = s.toCharArray();
        for (int i = 0;i < chars.length - 1;i++){
            s2 += chars[i+1];
        }
        String c1 = String.valueOf(c);
        String s4 = c1.toUpperCase();
        String s1 = s2.toLowerCase();
        String s3 = s4 + s1;

        System.out.println(s3);
    }
}
