package com.lifeng.java.day14.demo;

import java.util.Arrays;
import java.util.UUID;

/**
 * @author lifeng
 * @create 2022-07-07 14:19
 */
public class demo3 {
    public static void main(String[] args) {
        int[] arr = {5,2,7,9,34,4,5};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int[] ints = Arrays.copyOf(arr, arr.length + 5);
        System.out.println(Arrays.toString(ints));

        UUID uuid = UUID.randomUUID();
        String replace = uuid.toString().replace("-", "");
        System.out.println(replace);

    }
}
