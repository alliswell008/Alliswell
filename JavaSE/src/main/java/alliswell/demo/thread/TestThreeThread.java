package alliswell.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 *原文：https://blog.csdn.net/u011519624/article/details/79039380
 */
public class TestThreeThread {

    private static ExecutorService executor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws InterruptedException {

        for (int i=0; i<100; i++){
            Thread t1 = new Thread(new MyThread1(Thread.currentThread()));
            Thread t2 = new Thread(new MyThread2());
            Thread t3 = new Thread(new MyThread3());
            t1.start();
            /**join的意思是使得放弃当前线程的执行，并返回对应的线程，例如下面代码的意思就是：
             程序在main线程中调用t1线程的join方法，则main线程放弃cpu控制权，并返回t1线程继续执行直到线程t1执行完毕
             所以结果是t1线程执行完后，才到主线程执行，相当于在main线程中同步t1线程，t1执行完了，main线程才有执行的机会
             */
    //        t1.join();
            synchronized (Thread.currentThread()) {
                Thread.currentThread().wait();
        }
        t2.start();
        t2.join();
        t3.start();
        t3.join();// 可以没有，但与main方法的线程顺序就不可控了


        // 利用并发包里的Excutors的newSingleThreadExecutor产生一个单线程的线程池，
        // 而这个线程池的底层原理就是一个先进先出（FIFO）的队列。
        // 代码中executor.submit依次添加了123线程，按照FIFO的特性，执行顺序也就是123的执行结果，从而保证了执行顺序。
//        executor.submit(t1);
//        executor.submit(t2);
//        executor.submit(t3);
//        executor.shutdown();

        System.out.println("main is over");}
    }
}

class MyThread1 implements Runnable {

    Thread t;

    public MyThread1(Thread t) {
        this.t = t;
    }

    @Override
    public void run() {
        System.out.println("I am thread 1");
        synchronized (t) {
            t.notifyAll();
        }
    }
}

class MyThread2 implements Runnable {
    @Override
    public void run() {
        System.out.println("I am thread 2");
    }
}

class MyThread3 implements Runnable {
    @Override
    public void run() {
        System.out.println("I am thread 3");
    }
}