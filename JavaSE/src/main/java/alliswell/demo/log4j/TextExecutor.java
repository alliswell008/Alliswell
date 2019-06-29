package alliswell.demo.log4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class TextExecutor {
    public ExecutorService fixedExecutorService = Executors.newFixedThreadPool(5);
    public ExecutorService cachedExecutorService = Executors.newCachedThreadPool();
    public ExecutorService singleExecutorService = Executors.newSingleThreadExecutor();
    public ExecutorService customerExecutorService = new ThreadPoolExecutor(3, 5, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

    public void testExecutorException() {
        for (int i = 0; i < 10; i ++) {
            // 增加isShutdown()判断  
            if (!fixedExecutorService.isShutdown()) {
                fixedExecutorService.execute(new SayHelloRunnable());
            }
            fixedExecutorService.shutdown();
        }
    }

    public void testCustomerExecutorException() {
        for (int i = 0; i < 6; i ++) {
            customerExecutorService.execute(new SayHelloRunnable());
        }
    }

    private class SayHelloRunnable implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block  
                e.printStackTrace();
            } finally {
                System.out.println("hello world!");
            }

        }
    }

    public static void main(String[] args) {
        TextExecutor testExecutor = new TextExecutor();
        testExecutor.testCustomerExecutorException();;
    }
}  