package com.lifeng.java.day28.demo;

/**
 * @author lifeng
 * @create 2022-07-27 11:39
 */
public class demo3 {
    public static void main(String[] args) {

        Print1 print1 = new Print1();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    print1.print1();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    print1.print2();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    print1.print3();
                }
            }
        }).start();

    }
}

class Print1 {

    private int i = 1;

    public void print1(){
        synchronized(this){
            while (i != 1){
                try {
                    this.wait();
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

            i = 2;
            this.notifyAll();

        }
    }

    public void print2(){
        synchronized (this){
            while (i != 2){
                try {
                    this.wait();
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

            i = 3;
            this.notifyAll();

        }
    }

    public void print3(){
        synchronized (this){

            while (i != 3){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.print("八");
            System.out.print("百");
            System.out.print("里");
            System.out.print("分");
            System.out.print("麾");
            System.out.print("下");
            System.out.print("豸");
            System.out.println();

            i = 1;
            this.notifyAll();//唤醒另外一个等待的线程

        }
    }

}