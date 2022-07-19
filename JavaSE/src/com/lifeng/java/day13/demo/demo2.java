package com.lifeng.java.day13.demo;

/**
 * @author lifeng
 * @create 2022-07-06 14:31
 */
public class demo2 {
    public static void main(String[] args) {
//        Integer i1 = new Integer(111);
//        System.out.println(i1);
//
//        Integer i2 = new Integer("123456");
//        System.out.println(i2);
//
//        //intValue():
//        System.out.println("将Integer包装类类型转为int" + i1.intValue());
//
//        //常用：parseInt：将数字字符串类型转换为Integer
//        String s3 = "44646444";
//        System.out.println(Integer.parseInt(s3));
//
//        //valueOf(int i):静态的，将int类型转换为Integer
//        int i = 100;
//        System.out.println(Integer.valueOf(i));




        //自动装箱 int---Integer
        int i = 2;
        Integer integer = i;
        System.out.println(integer);//2

        //自动拆箱 Integer---int
        Integer integer1 = new Integer(12);
        integer1 += 2;
        System.out.println(integer1);//14


        //将Integer类型转为int
        Integer integer2 = new Integer(14);
        System.out.println(integer2.intValue());//14
        //将int转为Integer
        int i1 = 7;
        System.out.println(Integer.valueOf(i1));//7
        //将数字格式字符串转为int
        System.out.println(Integer.parseInt("12345678"));//12345678
        //将数字格式字符串转为Integer
        System.out.println(Integer.valueOf("123"));//123
        //将int转为String
        System.out.println(Integer.toString(i1));//7

        Integer i5 = 127;
        Integer i6 = 127;
        System.out.println(i5==i6);

    }
}
