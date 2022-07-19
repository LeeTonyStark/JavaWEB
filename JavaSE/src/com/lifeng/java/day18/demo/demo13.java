package com.lifeng.java.day18.demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map集合常用方法和遍历
 * @author lifeng
 * @create 2022-07-13 17:45
 */
public class demo13 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();

        //put方法用于增加或修改键值对
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
        //clear()用于清空集合
//        map.clear();
        //put()用于通过键找到对应的值
//        System.out.println(map.get("8848"));
//        //remove()用于通过键来删除整个键值对
////        map.remove("80");
//        System.out.println(map);
//
//        //size()获取map集合的长度
//        System.out.println(map.size());
//
//        //containsKey():判断map集合中是否包含某个键
//        System.out.println(map.containsKey("8081"));
//
//        //containsValue():判断map集合中是否包含某个值
//        System.out.println(map.containsValue("MySql数据库"));
//
//        //使用keySet()将map集合中所有的键存储在Set集合中
//        Set<String> set = map.keySet();
//        for (String key : set) {
//            System.out.print(key+",");
//        }
//        System.out.println();
//        //使用values()将map集合中的所有
//        Collection<String> values = map.values();
//        for (String value : values) {
//            System.out.print(value+",");
//        }
        //使用entrySet()获取map集合所有的键值对
//        Set<Map.Entry<String, String>> entries = map.entrySet();
//        for (Map.Entry<String, String> entry : entries) {
//            System.out.println(entry.getKey() + "  ...  " + entry.getValue());
//        }
//        System.out.println("map集合遍历的方式一:通过entrySet()遍历集合");
//        Set<Map.Entry<String,String>> entry = map.entrySet();
//        for(Map.Entry<String,String> entry1 : entry){
//            System.out.println(entry1.getKey() + "..." + entry1.getValue());
//        }
        System.out.println("map集合遍历的方式二：通过键获得值，调用keySet()方法");
        Set<String> set = map.keySet();
        for (String key : set) {
            System.out.println(key + "..." + map.get(key));
        }


    }
}
