package com.lifeng.java.day27.demo;

/**
 * 多线程的实现方式二：实现Runnable接口
 *
 * @author lifeng
 * @create 2022-07-26 14:20
 */
public class demo2 {
    public static void main(String[] args) {

        //3.
        Thread thread1 = new Thread(new Thread111());
        thread1.setName("线程一");
        thread1.start();

        Thread thread2 = new Thread(new Thread111());
        thread2.setName("线程二");
        thread2.start();

    }
}

//1.定义一个类，实现Runnable接口
class Thread111 implements Runnable{


    //2.重写run(),在run()中写线程要执行的代码
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + "..." + i);
        }
    }

}


