package com.lifeng.java.day13.demo;

/**
 * @author lifeng
 * @create 2022-07-06 9:06
 */
public class demo1 {
    public static void main(String[] args) {
//        System.out.println(new StringBuilder());
//        System.out.println(new StringBuilder("aasasa"));

        StringBuilder s = new StringBuilder("sasas");
        System.out.println("s:" + s.append(12121).append(".,,,/,,,."));

//        System.out.println(s.capacity());

        String s3 = s.toString();
        System.out.println("s3:" + s3);
//        System.out.println(s.reverse());

//        String s2 = new String(".,,,/,,,.12121sasas");


        System.out.println(s3.equals(s.toString()));

    }
}
