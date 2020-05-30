package alliswell.demo.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/4/5
 */
public class CountDownLatchDemo {

    static class Runner implements Callable<Integer> {
        // 开始信号
        private CountDownLatch begin;
        // 结束信号
        private CountDownLatch end;

        public Runner(CountDownLatch begin, CountDownLatch end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        public Integer call() throws Exception {
            System.out.println(Thread.currentThread().getName() + "发令枪响前");
            // 等待发令枪响起
            begin.await();
            // 跑步的成绩
            int score = new Random().nextInt(25);
            System.out.println(Thread.currentThread().getName() + "跑步成绩：" + score);
            // 跑步中...
            TimeUnit.MILLISECONDS.sleep(score);
            // 跑步者已经跑完全程
            end.countDown();
            System.out.println(Thread.currentThread().getName() + "跑完");
            return score;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 参加赛跑人数
        int num = 10;
        // 发令枪只响一次
        CountDownLatch begin = new CountDownLatch(1);
        // 参与跑步有多个
        CountDownLatch end = new CountDownLatch(num);
        // 每个跑步者一个跑道，开启线程池
        ExecutorService es = Executors.newFixedThreadPool(num);
        // 记录比赛成绩
        List<Future<Integer>> futures = new ArrayList<>();
        // 跑步者就位，所有线程处于等待状态
        for (int i = 0; i < num; i++) {
            futures.add(es.submit(new Runner(begin, end)));
        }
        // 发令枪响，跑步者开始跑步
        begin.countDown();
        System.out.println(Thread.currentThread().getName() + "发令枪响后");
        // 等待所有跑步者跑完全程
        end.await();
        if (end.getCount() == 0) System.out.println("跑完后");
        int count = 0;
        // 统计总分
        for (Future<Integer> f : futures) {
            count += f.get();
        }
        System.out.println(Thread.currentThread().getName() + "总分数：" + count + "平均分数为：" + count / num);
        // 关闭线程池
        es.shutdown();
    }

}
