package alliswell.demo.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * int同步和AtomicInteger比较，当量足够大时int同步效率明显高于AtomicInteger
 *
 * @author chengxs
 * @date 2020/11/5
 */
public class ThreadTest003 {

    private static AtomicInteger ai = new AtomicInteger(0);
    private static int k = 0;

    public static void main(String[] args) throws InterruptedException {
        getAtomicIntegerTime();
        getSynchorizedTime();

    }

    private static void getAtomicIntegerTime() throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(100);
        // TODO Auto-generated method stub
        ExecutorService es = Executors.newCachedThreadPool();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            es.execute(new Runnable() {

                @Override
                public void run() {
                    for (int j = 0; j < 100000; j++) {
                        ai.incrementAndGet();
                    }
                    latch.countDown();
                }
            });

        }
        latch.await();
        es.shutdown();
        long end = System.currentTimeMillis();
        System.out.println(ai.get() + "  耗时：" + (end - begin));
    }

    private static void getSynchorizedTime() throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(100);
        ExecutorService es = Executors.newCachedThreadPool();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            es.execute(new Runnable() {

                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    synchronized (ThreadTest003.class) {
                        for (int j = 0; j < 100000; j++) {
                            k++;
                        }
                        latch.countDown();
                    }
                }
            });

        }
        latch.await();
        es.shutdown();
        long end = System.currentTimeMillis();
        System.out.println(k + "  耗时：" + (end - begin));
    }
}