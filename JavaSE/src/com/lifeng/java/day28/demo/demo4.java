package com.lifeng.java.day28.demo;

/**
 * @author lifeng
 * @create 2022-07-27 14:33
 */
public class demo4 {
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    Print2.print1();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    Print2.print2();
                }
            }
        }).start();
    }
}

class Print2{

    private static boolean flag = true;

    public static synchronized void print1(){
        if (!flag){
            try {
                Print2.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("醉");
        System.out.print("里");
        System.out.print("挑");
        System.out.print("灯");
        System.out.print("看");
        System.out.print("剑");
        System.out.println();

        flag = false;
        Print2.class.notify();

    }

    public static synchronized void print2(){
        if (flag){
            try {
                Print2.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("梦");
        System.out.print("回");
        System.out.print("吹");
        System.out.print("角");
        System.out.print("连");
        System.out.print("营");
        System.out.println();

        flag = true;
        Print2.class.notify();

    }
}
