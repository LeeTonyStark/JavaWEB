package com.lifeng.java.day24.demo;

import java.io.InputStream;

/**
 * @author lifeng
 * @create 2022-07-21 15:11
 */
public class demo5 {
    public static void main(String[] args) {
        //获取类的字节码文件对象
        Class clazz = Person.class;
        //通过类的字节码文件对象获取类加载器对象
        ClassLoader classLoader = clazz.getClassLoader();
        //
        InputStream resourceAsStream = classLoader.getResourceAsStream("aaa.properties");
        System.out.println(resourceAsStream);
    }
}

class Person{

}