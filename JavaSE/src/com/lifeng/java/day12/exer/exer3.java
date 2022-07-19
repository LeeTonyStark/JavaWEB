package com.lifeng.java.day12.exer;

/**
 * @author lifeng
 * @create 2022-07-05 19:41
 */
public class exer3 {

    public static void main(String[] args) {

        //2.需求: 遍历字符串(三种方式来实现)
        //方式一：使用toCharArray()转换为char型数组
        String s = new String("fjswjsnxkwydgoaj");
        char[] chars = s.toCharArray();
        System.out.println("方式一：");
        for (int i = 0;i < chars.length ;i++){
            System.out.print(chars[i]);
        }
        System.out.println();

        //方式二：将遍历出来的字节码使用charAt()转换为字符
        System.out.println("方式二：");
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i));
        }
        System.out.println();

        //方式三:
        System.out.println("方式三：");
        for (int i = 0; i < s.length();i++){
            System.out.print(s.substring(i,i+1));
        }
        System.out.println();

        //方式四：
        System.out.println("方式四：");
        String[] split = s.split("");
        for (int i = 0; i < split.length; i++) {
            System.out.print(split[i]);
        }


    }

}
