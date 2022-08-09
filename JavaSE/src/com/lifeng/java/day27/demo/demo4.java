package com.lifeng.java.day27.demo;

/**
 * 线程优先级和守护线程的方法测试
 * @author lifeng
 * @create 2022-07-26 15:54
 */
public class demo4 {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();

        Thread thread1 = new Thread(myRunnable);
        thread1.setName("线程一：");
//        thread1.setPriority(1);//设置优先级为1
        System.out.println(thread1.getPriority());//获取优先级
//        thread1.setDaemon(true);//设置为守护线程，当主线程执行完毕后守护线程被杀掉
        thread1.start();

        Thread thread2 = new Thread(myRunnable);
        thread2.setName("线程二：");
//        thread2.setPriority(10);
        System.out.println(thread2.getPriority());
//        thread2.setDaemon(true);
        thread2.start();

//        Thread.currentThread().setName("主线程：");
//        for (int i = 1; i <= 50; i++) {
//            System.out.println(Thread.currentThread().getName() + i);
//        }
    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}
