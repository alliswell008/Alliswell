/**
 * @Title: FutureTest
 * @Package test
 * @Description: TODO(用一句话描述该文件做什么)
 * @author a
 * @date 2017/3/27 14:10
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package alliswell.demo.thread;

/**
 * @author a
 * @Title: FutureTest
 * @Package test
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017/3/27 14:10
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        final ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 2; i++) {

            fun(exec);
        }
        exec.shutdown();
    }

    static void fun(ExecutorService exec) throws ExecutionException, InterruptedException, TimeoutException {
//        final ExecutorService exec = Executors.newFixedThreadPool(5);
        Callable call = new Callable() {
            public String call() throws Exception {
                Thread.sleep(1000 * 7);
                return "Other less important but longtime things.";
            }
        };
        Future task = exec.submit(call);

        FutureTask<String> tt = getNum();
        String num = tt.get(2L, TimeUnit.SECONDS);

        //重要的事情
        Thread.sleep(1000 * 1);
        System.out.println("Let's do important things.");

        while (task.isDone()) {
            //其他不重要的事情
            String obj = (String) task.get(6L, TimeUnit.SECONDS);
            System.out.println(obj);
            break;
        }
        //关闭线程池
//        exec.shutdown();
    }

    private static FutureTask<String> getNum() {
        return new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "1111";
            }
        });
    }
}