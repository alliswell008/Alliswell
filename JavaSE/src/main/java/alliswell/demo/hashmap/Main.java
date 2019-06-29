package alliswell.demo.hashmap;

/**
 * Created by Administrator on 2018/3/2.
 */

import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    public static void main(String[] args)
    {
//        ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<>();
//        ArrayList<String> list = new ArrayList<String>();
//        Thread threads[] = new Thread[100];
//
//        for (int i = 0; i < threads.length; i++) {
//            AddTask task = new AddTask(list);
//            threads[i] = new Thread(task);
//            threads[i].start();
//        }
//        System.out.printf("Main: %d AddTask threads have been launched\n", threads.length);
//
//        for (int i = 0; i < threads.length; i++) {
//            try {
//                threads[i].join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.printf("Main: Size of the List: %d\n", list.size());
//
//        for (int i = 0; i < threads.length; i++) {
//            RemoveTask task = new RemoveTask(list);
//            threads[i] = new Thread(task);
//            threads[i].start();
//        }
//        System.out.printf("Main: %d RemoveTask threads have been launched\n", threads.length);
//
//        for (int i = 0; i < threads.length; i++) {
//            try {
//                threads[i].join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.printf("Main: Size of the List: %d\n", list.size());

        HashMap<String, String> map = new HashMap<>();
        map.put(null, null);
        map.put(null, null);
        Hashtable<String, String> ta = new Hashtable<>();
//        ta.put(null, null);
        System.out.println(map.size() + "-" + ta.size());


        Set a = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });

    }



    private static Lock rlock = new ReentrantReadWriteLock().readLock();

    private static Lock lock = new ReentrantLock();

    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();


    private static int nextSerialNum = 0;
    private static ThreadLocal serialNum = new ThreadLocal() {
        @Override
        protected synchronized Object initialValue() {
            return new Integer(nextSerialNum++);
        }
    };

    public static int get() {
        serialNum.set(111);
        serialNum.get();
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //释放一个请求
        semaphore.release();
        return ((Integer) (serialNum.get())).intValue();
    }

    static Semaphore semaphore = new Semaphore(5,true);




}