package src.main.java.org.alliswell.pattern.singleton;

import java.util.HashMap;
import java.util.concurrent.*;

/**
 * @ClassName: Starter
 * @Description: 多线程下�?7种单例模�?
 * @author alliswell
 * @date 2019-03-10 下午6:16:32
 *
 */
public class MThreadStarter {

    public static HashMap<String, String> typeMap = new HashMap<>();
    static {
        typeMap.put("hungry", "恶汉模式");
        typeMap.put("lazy1", "懒汉模式-1");
        typeMap.put("lazy2", "懒汉模式-2");
        typeMap.put("lazy3", "懒汉模式-3");
        typeMap.put("staticBlock", "静�?�代码块");
        typeMap.put("staticInnerClass", "静�?�内部类");
        typeMap.put("enum", "枚举");
    }

    public static void main(String[] args) throws InterruptedException {
        // 通过运行结果可知�?
        // 恶汉模式和懒汉模�?-1在多线程中不能实现单例，也就是这两个模式只能用在单线程中实现单例
        Thread t1 = new MainThread("hungry");
        t1.start();t1.join();
        Thread t2 = new MainThread("lazy1");
        t2.start();t2.join();
        Thread t3 = new MainThread("lazy2");
        t3.start();t3.join();
        Thread t4 = new MainThread("lazy3");
        t4.start();t4.join();
        Thread t5 = new MainThread("staticBlock");
        t5.start();t5.join();
        Thread t6 = new MainThread("staticInnerClass");
        t6.start();t6.join();
        Thread t7 = new MainThread("enum");
        t7.start();t7.join();

    }
}

class SingletonRunnable implements Runnable {

    String type = null;
    Object singleton = null;

    public SingletonRunnable(String type) {
        this.type = type;
    }

    @Override
    public void run() {

        switch (type) {
            case "hungry":
                singleton = Singleton_lazy.getInstance();
                break;
            case "lazy1":
                singleton = Singleton_lazy.getInstance();
                break;
            case "lazy2":
                singleton = Singleton_lazy2.getInstance();
                break;
            case "lazy3":
                singleton = Singleton_lazy3.getInstance();
                break;
            case "staticBlock":
                singleton = Singleton_staticBlock.getInstance();
                break;
            case "staticInnerClass":
                singleton = Singleton_staticInnerClass.getInstance();
                break;
            case "enum":
                singleton = Singleton_enum.getInstance();
                break;
        }

        System.out.println(singleton.hashCode() + ":" + MThreadStarter.typeMap.get(type));
    }
}


class MainThread extends Thread {
    ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 100, 200, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<Runnable>(10));
    String type = null;

    public MainThread(String type) {
        this.type = type;
    }

    @Override
    public void run() {
        SingletonRunnable[] mts = new SingletonRunnable[10];
        for (int i = 0; i < mts.length; i++) {
            mts[i] = new SingletonRunnable(type);
        }

        for (int j = 0; j < mts.length; j++) {
            // 不使用线程池
//            Thread t = new Thread(mts[j]);
//            t.start();

            // 使用线程�?
            executor.execute(mts[j]);
            System.out.println("线程池中线程数目�?" + executor.getPoolSize() + "，队列中等待执行的任务数目：" +
                    executor.getQueue().size() + "，已执行玩别的任务数目：" + executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }
}