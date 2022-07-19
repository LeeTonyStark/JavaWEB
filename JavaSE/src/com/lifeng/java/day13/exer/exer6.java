package com.lifeng.java.day13.exer;

/**
 * 3.分析以下需求，并用代码实现：
 * 	(1)定义如下方法public static String getPropertyGetMethodName(String property);
 * 	(2)该方法的参数为String类型，表示用户给定的成员变量的名字，返回值类型为String类型，
 * 	返回值为成员变量对应的get方法的名字
 * 	(3)如：用户调用此方法时给定的参数为"name",该方法的返回值为"getName"
 * @author lifeng
 * @create 2022-07-06 19:06
 */
public class exer6 {

    public static void main(String[] args) {
        System.out.println(exer6.getPropertyGetMethodName("name"));
    }

    public static String getPropertyGetMethodName(String property){

        String str = "get";
        //取出参数第一个字母
        String substring = property.substring(0, 1);
        //变大写
        String big = substring.toUpperCase();
        //替换
        String replace = property.replace(substring, big);
        str += replace;

//        System.out.println(str);
        return str;
    }
}
