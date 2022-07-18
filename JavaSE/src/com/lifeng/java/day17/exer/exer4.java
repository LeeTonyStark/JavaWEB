package com.lifeng.java.day17.exer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.Collections.frequency;


/**
 * 4.分析以下需求，并用代码实现：
 * 	(1)有如下代码：
 * 		List<String> list = new ArrayList<>();
 *
 * 		list.add("a");
 * 		list.add("a");
 * 		list.add("a");
 * 		list.add("b");
 * 		list.add("b");
 * 		list.add("c");
 * 		list.add("d");
 * 		list.add("d");
 * 		list.add("d");
 * 		list.add("d");
 * 		list.add("d");
 *
 * 		System.out.println(frequency(list, "a"));
 * 		System.out.println(frequency(list, "b"));
 * 		System.out.println(frequency(list, "c"));
 * 		System.out.println(frequency(list, "d"));
 * 		System.out.println(frequency(list, "xxx"));
 * 	(2)定义方法统计集合中指定元素出现的次数，如"a" 3,"b" 2,"c" 1
 *
 * @author lifeng
 * @create 2022-07-12 17:52
 */
public class exer4 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

  		list.add("a");
  		list.add("a");
  		list.add("a");
  		list.add("b");
  		list.add("b");
  		list.add("c");
  		list.add("d");
  		list.add("d");
  		list.add("d");
  		list.add("d");
  		list.add("d");

  		System.out.println(frequency(list, "a"));
  		System.out.println(frequency(list, "b"));
  		System.out.println(frequency(list, "c"));
  		System.out.println(frequency(list, "d"));
  		System.out.println(frequency(list, "xxx"));
    }

    /**
     *
     * @param list 集合对象
     * @param s 想要查找的数
     * @return
     */
    public static int frequency(Collection list, String s){
		int Count = 0;
		for (Object o : list) {
			String s1 = (String) o;
			if (s1.equals(s)){
				Count++;
			}
		}
        return Count;
    }
}
