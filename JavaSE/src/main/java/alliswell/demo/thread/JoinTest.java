package alliswell.demo.thread;

/**
 * 现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行
 *
 * @author chengxs
 * @date 2020/12/10
 */
public class JoinTest {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            fun();
        }
    }

    public static void fun() {
        final Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("t1");
            }
        });
        final Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    // 引用t1线程，等待t1线程执行完
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2");
            }
        });
        Thread t3 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    // 引用t2线程，等待t2线程执行完
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t3");
                System.out.println("-----------");
            }
        });

        //这里三个线程的启动顺序可以任意，大家可以试下！
        t1.start();
        t2.start();
        t3.start();

        try {
            // main线程等待t3线程执行完，才继续执行for循环
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
