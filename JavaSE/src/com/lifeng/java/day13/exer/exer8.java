package com.lifeng.java.day13.exer;

/**
 * 5.定义一个MyStringUtil工具类，该类中定义三个方法，要求如下：
 * 	(1)public static char[] toCharArray(String str) : 将给定的参数字符串转成对应的字符数组
 * 	（不能直接调用jdk中的工具类及String类中的tocharArray方法）
 * 	(2)public static String getSingleString(String str) : 去除给定的参数字符串中的重符字符
 * 	（重复字符只保留一个），将新的字符串返回
 * 	(3)public static boolean isBalancedString(String str): 如果左右两边字符相同则返回true，
 * 	否则返回false，例如：abccba是对称字符
 * 					  例如：abcdecba不是对称字符
 * @author lifeng
 * @create 2022-07-06 19:28
 */
public class exer8 {
    public static void main(String[] args) {
        //toCharArray方法：
        char[] chars = MyStringUtil.toCharArray("12345");
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }

        System.out.println();
        //2.getSingleString(String str) 方法
        String sahggasec = MyStringUtil.getSingleString("sssaaahggaseeeccc");
        System.out.println(sahggasec);

        //(3)public static boolean isBalancedString(String str):
        System.out.println(MyStringUtil.isBalancedString("abcba"));
    }
}

class MyStringUtil{
    public static char[] toCharArray(String str){
        char[] chars = new char[str.length()];
        String s = "";
        String[] split = str.split("");
        for (int i = 0; i < split.length; i++) {
            s += split[i];
            chars[i] = s.charAt(i);
        }
        return chars;
    }
    public static String getSingleString(String str){
        char[] chars = MyStringUtil.toCharArray(str);
        char c = str.charAt(0);
        String newStr =new String();
        newStr += c;
        for (int i = 0; i < chars.length - 1; i++) {

            if (!(chars[i] == chars[i+1])){
                newStr += chars[i+1];
            }
        }
        return newStr;
    }
    public static boolean isBalancedString(String str){
        StringBuilder stringBuilder = new StringBuilder(str);
        StringBuilder reverse = stringBuilder.reverse();
        if (str.equals(reverse.toString())){
            return true;
        }
        return false;
    }
}
