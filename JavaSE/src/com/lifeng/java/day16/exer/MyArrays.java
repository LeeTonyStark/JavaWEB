package com.lifeng.java.day16.exer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author lifeng
 * @create 2022-07-11 17:58
 */
public class MyArrays {

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(123);
        integers.add(456);
        integers.add(789);
        reverse(integers);
        System.out.println(max(integers));
        System.out.println(min(integers));
        System.out.println(integers.indexOf(789));
        replaceAll(integers,789,333);
        System.out.println(integers);
    }
    /*
    参数ArrayList<Integer> list:要进行操作的集合对象
 * 		要求：对list集合对象中的元素进行反转(第一个和最后一个交换，
        第二个和倒数第二个交换，第三个和倒数第三个交换...)
     */
    public static void reverse(ArrayList<Integer> list) {
        ArrayList<Integer> integers = new ArrayList<>();//接收反转后的数据
        Object[] objects = list.toArray();
        int j = 0;
        for (int i = objects.length - 1; i > -1; i--) {
            Integer integer = (Integer)objects[i];
            integers.add(j,integer);
            j++;
        }
        System.out.println(integers);
    }

    /*
    参数ArrayList<Integer> list:要进行操作的集合对象
 * 		要求：求出list集合对象中的最大值并返回
     */
    public static Integer max(ArrayList<Integer> list){
        Integer max = 0;
        for (Integer integer : list) {
            if (integer > max){
                max = integer;
            }
        }
        return max;
    }

    /*
    参数ArrayList<Integer> list:要进行操作的集合对象
 * 		要求：求出list集合对象中的最小值并返回
     */
    public static Integer min(ArrayList<Integer> list){
        Integer min = list.get(0);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            if (iterator.next() < min){
                min = iterator.next();
            }
        }
        return min;
    }

    /*
    参数ArrayList<Integer> list:要进行操作的集合对象
 * 		参数Integer i:需要在集合中查找的元素
 * 		要求：求出元素i在list集合中第一次出现的索引，如果没有返回-1
     */
    public static int indexOf(ArrayList<Integer> list,Integer i){
        for (int i1 = 0; i1 < list.size(); i1++) {
            if (list.get(i).equals(i)){
                return i;
            }
        }
        return -1;
    }

    /*
    参数ArrayList<Integer> list:要进行操作的集合对象
 * 		参数Integer oldValue:需要被替换掉的原值
 * 		参数Integer newValue：替换后的新值
 * 		要求：将list集合中的所有值为oldValue的元素替换为newValue
     */
    public static void replaceAll(ArrayList<Integer> list,Integer oldValue,Integer newValue){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(oldValue)){
                list.set(i,newValue);
            }
        }
    }
}
