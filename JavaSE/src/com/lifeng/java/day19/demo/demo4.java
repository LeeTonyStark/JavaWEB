package com.lifeng.java.day19.demo;

import java.util.*;

/**
 * @author lifeng
 * @create 2022-07-14 12:03
 */
public class demo4 {
    public static void main(String[] args) {
        TreeMap<String, Person> stringPerson1TreeMap = new TreeMap<>();
        stringPerson1TreeMap.put("aaa",new Person("佩奇1",12));
        stringPerson1TreeMap.put("bbb",new Person("佩奇2",13));
        stringPerson1TreeMap.put("ccc",new Person("佩奇3",14));
        stringPerson1TreeMap.put("ddd",new Person("佩奇4",15));

        Collection<String> collection = stringPerson1TreeMap.keySet();
        for (String key : collection){
            Person value = stringPerson1TreeMap.get(key);
            System.out.println(key + "....." + value);
        }

        TreeMap<Person, String> personStringTreeMap = new TreeMap<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getAge() - o1.getAge();
            }
        });
        personStringTreeMap.put(new Person("佩奇1",12),"aaa");
        personStringTreeMap.put(new Person("佩奇2",13),"aaa");
        personStringTreeMap.put(new Person("佩奇3",14),"aaa");
        personStringTreeMap.put(new Person("佩奇4",15),"aaa");

        Set<Map.Entry<Person,String>> set =  personStringTreeMap.entrySet();
        for (Map.Entry<Person, String> entry : set) {
            System.out.println(entry.getKey() + "....." + entry.getValue());
        }

    }
}
