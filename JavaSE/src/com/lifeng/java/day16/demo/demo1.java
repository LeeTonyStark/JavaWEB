package com.lifeng.java.day16.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

/**
 * 集合：
 *      集合就是容器，用来装东西。
 *      集合容器的特点：
 *          1.集合容器的长度是可以变化的
 *          2.集合容器只能存储引用数据类型
 *          3.一个集合容器中可以存储不同引用类型的数据
 *
 *       集合容器与数组容器的区别？
 *          1.
 *              集合容器的长度是可以变化的
 *              数组容器一旦初始化长度就不能改变了
 *          2.
 *              集合容器只能存储引用数据类型
 *              数组容器既可以存储基本数据类型，也可以存储引用数据类型
 *          3.
 *              一个集合容器中可以存储不同引用数据类型的数据
 *              一个数组容器中只能存储同一种数据类型的数据
 * @author lifeng
 * @create 2022-07-09 9:29
 */
public class demo1 {
    public static void main(String[] args) {

        //创建集合容器
        Collection c = new ArrayList();

        //添加元素
        c.add("aaa");
        c.add("zzz");
        c.add("www");
        c.add("w");
        //添加对象元素
        Pig pig = new Pig("大卫");
        c.add(pig);
        //清空元素
//        c.clear();
        c.remove("aaa");
        c.add("axa");
        c.add(123);
        c.add(8971);

        System.out.println("removeIf()之前"+c);

//        System.out.println(c.size());
//        System.out.println(c.contains("aaa"));
        //jdk1.8按条件删除 removeIf():
        c.removeIf(new Predicate() {
            @Override
            public boolean test(Object o) {
                //return true;//条件满足，就要把t元素删除
                return o instanceof Integer;//条件不满足，不能把t删了
            }
        });

        System.out.println("removeIf()之后"+c);



    }
}

class Pig{
    String name = "大卫";

    public Pig() {
    }

    public Pig(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Pig{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}
