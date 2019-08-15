package alliswell.demo.hashmap;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

public class WeakHashMapTest {

    public static void test1() throws Exception {
        //List<byte[][]> keys = new ArrayList<byte[][]>();
        byte[][] key = null;
        WeakHashMap<byte[][], byte[][]> maps = new WeakHashMap<byte[][], byte[][]>();
        for (int i = 0; i < 10000; i++) {
            key = new byte[1000][1000];

            maps.put(key, new byte[1000][1000]);

            // System.gc();
            System.err.println(i);

            System.err.println("test1 size" + maps.size());

        }
    }

    public static void test2() throws Exception {
        List<byte[][]> keys = new ArrayList<byte[][]>();
        byte[][] key = null;
        WeakHashMap<byte[][], byte[][]> maps = new WeakHashMap<byte[][], byte[][]>();

        for (int i = 0; i < 10000; i++) {
            key = new byte[1000][1000];
            // 模拟对象被其他对象引用，因为存在其他对象的应用，所以WeakHashMap中的对象不会被回收而一直占用内存直到内存溢出
            keys.add(key);
            // 模拟清除其他对象引用
            // keys.clear();
            maps.put(key, new byte[1000][1000]);

            // System.gc();
            System.err.println(i);

            System.err.println("test2 size" + maps.size());
        }
    }

    /**
     * 从test1()输出结果上可以发现，size的大小，会由小变大，突然变小，然后再由小变大。这个说明垃圾回收期在器作用，这个和jdk的说明文档是一致的：
     * 当GC开始回收的时候会发现，map的key已经不被使用了，即使map中key和value的映射已然存在，也不能阻止map的key被GC回收掉。当map的key被回收了之后，value对象也会被顺利地回收的
     * test2()执行到一半就会抛出OOM异常，这份代码和上一份代码的唯一区别就是，map的key放到一个list中，这样能保证方法体中的所有key都是被引用的，所以在启动垃圾回收的时候，weak中的key一个都不会被自动回收，所以OOM就在所难免了
     * 所以在使用WeakHashMap的时候，千万注意，使用完某个key如果希望对象会被自动回收，需要与map的key的所有引用关系切断
     */
    public static void main(String[] args) throws Exception {
        test1();

        System.out.println("=============");

        test2();
    }
}
