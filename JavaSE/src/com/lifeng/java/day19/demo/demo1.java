package com.lifeng.java.day19.demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author lifeng
 * @create 2022-07-14 11:05
 */
public class demo1 {
    public static void main(String[] args) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        /*
            map.put("端口号","服务名");
            map.put("3306","MySql数据库");
            map.put("1521","Oracle数据库");
            map.put("1433","SqlServer数据库");
            map.put("8080","Tomcat服务器");
            map.put("80","Nginx(动态代理、负载均衡、静态分离)");
            map.put("6379","Redis(非关系型数据库)");
            map.put("8066","MyCat数据库中间件");
            map.put("2181","Zookeeper分布式协调服务");
            map.put("8848","Nacos注册中心");
         */

        stringStringHashMap.put("3306","MySql数据库");
        stringStringHashMap.put("80","Nginx(动态代理、负载均衡、动静分离)");
        stringStringHashMap.put("8080","TomCat服务器");
        stringStringHashMap.put("8848","Nacos注册中心");
        stringStringHashMap.put("6379","Redis非关系型数据库");

        //遍历的方式一：
        Collection<String> collection = stringStringHashMap.keySet();
        for (String key : collection) {
            String values = stringStringHashMap.get(key);
            System.out.println(key + "..." + values);
        }
        System.out.println("----------------------------------------");
        //遍历方式二：
        Set<Map.Entry<String, String>> entries = stringStringHashMap.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "..." + value);
        }
    }
}
