package com.lifeng.java.day17.demo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author lifeng
 * @create 2022-07-11 19:30
 */
public class demo1 {
    public static void main(String[] args) {

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(112233);
        integers.add(34343);
        integers.add(390);

        //遍历容器
        for (Integer integer : integers) {
            System.out.println(integer);
        }

        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()){
            Integer i = iterator.next();
            System.out.println(i);
        }


        B<String> stringB = new B<>();
        stringB.print1("aaa");
        stringB.print1("bbb");
        stringB.print1("ccc");

    }

    //泛型方法
    public <T> void print(T t){

    }
}

interface A<T>{
    void print1(T t);
}

class B<T> implements A<T>{

    @Override
    public void print1(T t) {
        System.out.println(t);
    }
}

class C<E>{
    public void print(E e){
        System.out.println(e);
    }
}

class D{
    public <E> void print(E e){
        System.out.println(e);
    }
}

interface Inter<E>{
    public void print(E e);
}
//自定义泛型接口
class InterImpl<Integer> implements Inter<Integer>{

    @Override
    public void print(Integer e) {
        System.out.println(e);
    }

}