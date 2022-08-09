package com.lifeng.java.day27.demo;

/**
 * @author lifeng
 * @create 2022-07-30 0:27
 */
public class demo6 {
    public static void main(String[] args) {
        Ticket1 ticket1 = new Ticket1();
    }
}

class Ticket1 implements Runnable{

    private int ticket = 100;//票数
    @Override
    public void run() {
        while (true){
            if (ticket > 0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket + "张票");
                ticket--;
            }
        }
    }

}