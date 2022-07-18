package com.lifeng.java.day16.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author lifeng
 * @create 2022-07-09 10:32
 */
public class demo2 {
    public static void main(String[] args) {

        //集合的遍历：
        //方式一：将集合转成数组遍历
        //Object[] toArray()://将集合转换成数组
        Collection c = new ArrayList<>();
        c.add(123);
        c.add("alws");
        c.add(true);

        Object[] objects = c.toArray();//将集合转换成数组类型
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }

        //方式二：迭代器遍历
        //Iterator<> iterator():获取迭代器对象
        Iterator iterator = c.iterator();
        //boolean hasNext():判断下一个元素有么有
        //next():获取下一个元素
        while (iterator.hasNext()){
            Object next = iterator.next();//获取下一个元素
            System.out.println(next);
        }

        //方式三：增强for循环，foreach循环遍历
        /*
        格式:
            for(变量名 : 要遍历的容器名字){}
         */
        for (Object c1 : c) {
            System.out.println(c1);
        }

    }
}
