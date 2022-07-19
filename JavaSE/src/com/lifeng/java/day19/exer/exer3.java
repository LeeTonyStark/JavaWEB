package com.lifeng.java.day19.exer;

import java.util.*;

/**
 * 3.分析以下需求，并用代码实现：
 * 	(1)有类似这样的字符串："1.2,3.4,5.6,7.8,5.56,44.55"请按照要求，依次完成以下试题
 * 	(2)以逗号作为分隔符，把已知的字符串分成一个String类型的数组，数组中的每一个元素类似于"1.2","3.4"这样的字符串
 * 	(3)把数组中的每一个元素以"."作为分隔符，把"."左边的元素作为key，右边的元素作为value，封装到Map中，Map中的key和value都是Object类型
 * 	(4)把map中的key封装的Set中，并把Set中的元素输出
 * 	(5)把map中的value封装到Collection中，把Collection中的元素输出
 *
 * @author lifeng
 * @create 2022-07-14 19:43
 */
public class exer3 {
    public static void main(String[] args) {
        String s = "1.2,3.4,5.6,7.8,5.56,44.55";
        HashMap<Object, Object> map = new HashMap<>();
        Set set = new HashSet();//存储key
        Collection collection = new ArrayList();//存储value
        String[] split = s.split(",");
        for (int i = 0; i < split.length; i++) {
            String[] split1 = split[i].split("\\.");
            for (int i1 = 0; i1 < split1.length; i1++) {
                map.put(split1[0],split1[1]);
            }
        }

        Set<Map.Entry<Object, Object>> entries = map.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
             set.add(entry.getKey());
            collection.add(entry.getValue());
        }
        for (Object o : set) {
            System.out.println(o);
        }
        for (Object o : collection) {
            System.out.println(o);
        }

    }
}
