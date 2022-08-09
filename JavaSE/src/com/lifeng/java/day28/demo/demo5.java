package com.lifeng.java.day28.demo;

/**
 * @author lifeng
 * @create 2022-07-27 15:13
 */
public class demo5 {
    public static void main(String[] args) {
        String s1 = "左筷子";
        String s2 = "右筷子";

        new Thread("哲学家A"){
            @Override
            public void run() {
                while (true){
                    synchronized (this){
                        System.out.println(getName() + "拿到了" + s1 + ",等待" + s2);
                        synchronized (this){
                            System.out.println(getName() + "拿到了" + s2 + ",开吃");
                        }
                    }
                }
            }
        }.start();

        new Thread("哲学家B"){
            @Override
            public void run() {
                while (true){
                    synchronized (this){
                        System.out.println(getName() + "拿到了" + s2 + ",等待" + s1);
                        synchronized (this){
                            System.out.println(getName() + "拿到了" + s1 + ",开吃");
                        }
                    }
                }
            }
        }.start();

    }
}
