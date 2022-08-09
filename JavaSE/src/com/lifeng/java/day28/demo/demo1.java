package com.lifeng.java.day28.demo;

/**
 * 使用Syn解决线程安全问题
 * @author lifeng
 * @create 2022-07-27 9:44
 */
public class demo1 {
    public static void main(String[] args) {

        MyThread myThread = new MyThread();

        Thread thread1 = new Thread(myThread);
        thread1.setName("窗口一:");
        thread1.start();

        Thread thread2 = new Thread(myThread);
        thread2.setName("窗口二:");
        thread2.start();

        Thread thread3 = new Thread(myThread);
        thread3.setName("窗口三:");
        thread3.start();

    }
}

class MyThread implements Runnable{

    private int ticket = 100;//总量一百张票

    @Override
    public void run() {
        while (ticket > 0){
            synchronized (this){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "正在售卖第" + ticket + "张票");
                ticket--;

                if (ticket == 2){
                    break;
                }
            }
        }
    }
}