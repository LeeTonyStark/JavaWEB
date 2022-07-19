package com.lifeng.java.day19.exer;

import java.util.*;

/**2.分析以下需求，并用代码实现：
 (1)利用键盘录入，输入一个字符串
 (2)统计该字符串中各个字符的数量
 (3)如：
 用户输入字符串"If~you-want~to~change-your_fate_I_think~you~must~come-to-the-woniu-to-learn-java"
 程序输出结果：-(9)I(2)_(3)a(7)c(2)d(1)e(6)f(2)g(1)h(4)i(1)j(1)k(2)l(1)m(2)n(4)o(8)r(4)s(2)t(8)u(4)v(1)w(1)y(3)~(6)
 * @author lifeng
 * @create 2022-07-14 19:03
 */
public class exer2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
//        String s = "If~you-want~to~change-your_fate_I_think~you~must~come-to-the-woniu-to-learn-java";
        HashMap<String, Integer> map = new HashMap<>();
        TreeMap<String, Integer> tmap = new TreeMap<>();
        String[] split = next.split("");
        for (int i = 0; i < split.length; i++) {
            if (!(map.containsKey(split[i]))){
                map.put(split[i],1);
            }else {
                map.put(split[i],map.get(split[i])+1);
            }
        }

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();
            Integer value = entry.getValue();

//            System.out.print(key + "(" +value + ")");
        }
        tmap.putAll(map);
        Set<Map.Entry<String, Integer>> entries1 = tmap.entrySet();
        for (Map.Entry<String, Integer> stringIntegerEntry : entries1) {
            String key = stringIntegerEntry.getKey();
            Integer value = stringIntegerEntry.getValue();
            System.out.print(key + "(" +value + ")");
        }
    }
}
