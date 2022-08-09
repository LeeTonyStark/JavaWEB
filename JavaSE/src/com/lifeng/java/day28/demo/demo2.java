package com.lifeng.java.day28.demo;


import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lifeng
 * @create 2022-07-27 10:20
 */
public class demo2 {
    public static void main(String[] args) {
        Print print = new Print();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    print.print1();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    print.print2();
                }
            }
        }).start();
    }
}

class Print{

    //同步代码块加锁

//    public void print1(){
//        synchronized (this){
//            System.out.print("蜗");
//            System.out.print("牛");
//            System.out.print("学");
//            System.out.print("院");
//            System.out.println();
//        }
//    }
//
//    public void print2(){
//        synchronized (this){
//            System.out.print("J");
//            System.out.print("a");
//            System.out.print("v");
//            System.out.print("a");
//            System.out.println();
//        }
//    }

    //同步方法加锁

//    public synchronized void print1(){
//            System.out.print("蜗");
//            System.out.print("牛");
//            System.out.print("学");
//            System.out.print("院");
//            System.out.println();
//    }
//
//    public synchronized void print2(){
//            System.out.print("J");
//            System.out.print("a");
//            System.out.print("v");
//            System.out.print("a");
//            System.out.println();
//    }


    //静态同步方法加锁

//    public static synchronized void print1(){
//            System.out.print("蜗");
//            System.out.print("牛");
//            System.out.print("学");
//            System.out.print("院");
//            System.out.println();
//    }
//
//    public static synchronized void print2(){
//            System.out.print("J");
//            System.out.print("a");
//            System.out.print("v");
//            System.out.print("a");
//            System.out.println();
//    }

    //Lock方式加锁

    private ReentrantLock lock = new ReentrantLock();

    public void print1(){

        lock.lock();//加锁
        System.out.print("蜗");
        System.out.print("牛");
        System.out.print("学");
        System.out.print("院");
        System.out.println();
        lock.unlock();//解锁

    }

    public void print2(){
        lock.lock();
        System.out.print("J");
        System.out.print("a");
        System.out.print("v");
        System.out.print("a");
        System.out.println();
        lock.unlock();
    }
}
