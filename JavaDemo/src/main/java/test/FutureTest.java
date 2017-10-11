/**
 * @Title: FutureTest
 * @Package test
 * @Description: TODO(用一句话描述该文件做什么)
 * @author alliswell
 * @date 2017/3/27 14:10
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
 */
package test;

/**
 * @author alliswell
 * @Title: FutureTest
 * @Package test
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017/3/27 14:10
 */

import org.springframework.scheduling.annotation.AsyncResult;

import java.util.Map;
import java.util.concurrent.*;

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
        Callable call = new Callable(){
            public String call() throws Exception{
                Thread.sleep(1000 * 7);
                return "Other less important but longtime things.";
            }
        };
        Future task = exec.submit(call);

        Future<String> tt = getNum();
        String num = tt.get(2L, TimeUnit.SECONDS);

        //重要的事情
        Thread.sleep(1000 * 1);
        System.out.println("Let's do important things.");

        while (task.isDone()) {
            //其他不重要的事情
            String obj = (String)task.get(6L, TimeUnit.SECONDS);
            System.out.println(obj);
            break;
        }
        //关闭线程池
//        exec.shutdown();
    }

    private static Future<String> getNum() {
        return new AsyncResult("1111");
    }
}