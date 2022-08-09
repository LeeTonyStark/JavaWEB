package com.lifeng.java.day27.demo;

/**
 * @author lifeng
 * @create 2022-07-26 16:48
 */
public class demo5 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        Thread thread1 = new Thread(ticket,"窗口一：");
        thread1.start();

        Thread thread2 = new Thread(ticket,"窗口二：");
        thread2.start();

        Thread thread3 = new Thread(ticket,"窗口三：");
        thread3.start();
    }
}
//模拟卖票
class Ticket implements Runnable{

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
