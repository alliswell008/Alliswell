package alliswell.demo.thread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/4/5
 */
public class CyclicBarrierDemo {
    static class Worker implements Runnable {

        // 关卡或栅栏
        private CyclicBarrier cb;

        public Worker(CyclicBarrier cb) {
            this.cb = cb;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(new Random().nextInt(1000));
                System.out.println(Thread.currentThread().getName() + "-到达汇合点前");

                // 到达汇合点
                cb.await();

                System.out.println(Thread.currentThread().getName() + "-到达汇合点后");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(4, new Runnable() {

            @Override
            public void run() {
                System.out.println("隧道已经打通！");
            }
        });

        new Thread(new Worker(cb), "工人1").start();
        new Thread(new Worker(cb), "工人2").start();
        new Thread(new Worker(cb), "工人3").start();
        new Thread(new Worker(cb), "工人4").start();
    }
}
