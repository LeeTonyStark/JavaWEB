package com.lifeng.java.day13.demo;

/**
 * @author lifeng
 * @create 2022-07-06 16:19
 */
public class demo3 {
    public static void main(String[] args) {
        /*
        测试System类中的方法
         */

        //1.exit
//        System.out.println("开始");
//        System.exit(0);
//        System.out.println("结束");

        //2.currentTimeMillis():获取从1970-1-1到目前的毫秒数
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            System.out.print(i);
        }
        long end = System.currentTimeMillis();

        Long time = end - start;
        System.out.println("一共运行了" + time + "毫秒");

        //3.arraycopy(a,b,c,d,e)复制数组
        int[] arr = new int[]{1,2,3,4,5,6,7};
        int[] arr1 = new int[10];

        System.arraycopy(arr,1,arr1,1,6);
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }

    }
}
