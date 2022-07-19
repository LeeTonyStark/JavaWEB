package com.lifeng.java.day18.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author lifeng
 * @create 2022-07-13 16:17
 */
public class demo9 {
    public static void main(String[] args) {

        Map<String,String> map = new HashMap<>();
        String put = map.put("AAA", "杰克");
        String put1 = map.put("BBB", "佩奇");
        String put2 = map.put("CCC", "乔治");
        String put3 = map.put("CCC", "T");

        System.out.println(put);
        System.out.println(put1);
        System.out.println(put2);//若键不同，put()为添加,返回null
        System.out.println(put3);//若键相同，put()为修改,返回值为修改的元素

        System.out.println(map);//Map集合返回数据的格式为{key=value,key=value}
    }
}

