package com.lifeng.java.day27.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 *多线程实现方式四：实现Callable接口
 *
 * @author lifeng
 * @create 2022-07-26 14:36
 */
public class demo3 {
    public static void main(String[] args) {

        MyCallable myCallable = new MyCallable();

        FutureTask futureTask1 = new FutureTask<String>(myCallable);
        Thread thread1 = new Thread(futureTask1);
        thread1.start();

        FutureTask futureTask2 = new FutureTask<String>(myCallable);
        Thread thread2 = new Thread(futureTask2);
        thread2.start();
    }
}

class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        for (int i = 1;i <= 100;i++){
            System.out.println(i);
        }
        return "null";
    }
}
