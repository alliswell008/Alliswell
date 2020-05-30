package alliswell.demo.thread;

/**
 * Thread#join方法
 *
 * main
 * 线程1：join后，main让出CPU，zhi'dao
 * 线程1子线程1
 * 线程1子线程2
 * 线程2
 * 线程2子线程1
 * 线程2子线程2
 *
 * main--开始-->线程1--开始并join-->线程1子线程1--开始并join
 *          -->线程1      --开始，但要等待线程1子线程1执行完毕-->线程1子线程2-->main-->线程1子线程2-->线程2-->线程2子线程2
 *
 *
 * <p>参考资料：https://blog.csdn.net/u013425438/article/details/80205693
 *
 * @author chengxs
 * @date 2020/4/7
 */
public class ThreadJoinDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("------" + Thread.currentThread().getName() + "开始...");
        Thread t1 = new ThreadJoin();
        t1.setName("线程1");
        Thread t2 = new ThreadJoin();
        t2.setName("线程2");

        t1.start();
        t1.join();
        t2.start();
//        t2.join();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName());
        }
        System.out.println("------" + Thread.currentThread().getName() + "结束...");
    }
}

class ThreadJoin extends Thread {

    @Override
    public void run() {
        System.out.println("------" + Thread.currentThread().getName() + "开始...");
        Thread t1 = new SubThreadJoin();
        t1.setName(Thread.currentThread().getName() + "子线程1");
        Thread t2 = new SubThreadJoin();
        t2.setName(Thread.currentThread().getName() + "子线程2");

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
        System.out.println("------" + Thread.currentThread().getName() + "结束...");
    }
}

class SubThreadJoin extends Thread {

    @Override
    public void run() {
        System.out.println("------" + Thread.currentThread().getName() + "开始...");
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
        System.out.println("------" + Thread.currentThread().getName() + "结束...");
    }
}