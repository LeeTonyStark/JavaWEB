package com.lifeng.java.day13.exer;

/**
 * 7.已知一个字符数组arr,其中里面有{'a','s','d','f','a','d','2','3','8'},
 * 根据里面的元素随机生成一个长度为5的字符串，然后将该字符串去重后反序输出。
 * 	打印格式：
 * 		随机生成一个长度为5的字符串:s2aas
 * 		去除重复后：s2a
 * 		去除重复并倒序后：a2s
 * @author lifeng
 * @create 2022-07-06 20:56
 */
public class exer10 {
    public static void main(String[] args) {
        char[] arr = {'a','s','d','f','a','d','2','3','8'};
        //保存生成的字符串
        String s = "";
        int Count = 0;
        for (int i = 0; i < arr.length; i++) {

            if (Count < 5){
                s += arr[(int)(Math.random() * (arr.length-1))];
                Count++;
            }
        }
        System.out.println("随机生成一个长度为5的字符串:" + s);

        //定义一个空串接收
        String s2 = "";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //第一次出现的索引和最后一次出现的索引相同，直接添加
            if (s.indexOf(chars[i]) == s.lastIndexOf(chars[i])){
                s2 += (chars[i]);
            }else {
                if (s.indexOf(chars[i]) == i){
                    s2 += (chars[i]);
                }
            }
        }

        System.out.println("去除重复后：" + s2);

        StringBuilder stringBuilder = new StringBuilder(s2);
        StringBuilder reverse = stringBuilder.reverse();
        System.out.println("去除重复并倒序后:" + reverse);

    }
}
