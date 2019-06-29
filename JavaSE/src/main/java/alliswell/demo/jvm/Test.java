package alliswell.demo.jvm;

import alliswell.demo.spi.SPITest;

import java.lang.Object;
import java.lang.reflect.Method;

public class Test {

    public static void main(String args[]) throws Exception {

        /**
         * 模拟条件：父类加载器能找到这个HelloClassLoader类（不做处理）
         * 输出结果：
         *         恩，是的，我是由 class sun.misc.Launcher$AppClassLoader 加载进来的
         *         file:/D:/a/workspace/Alliswell/JavaDemo/target/classes/org/a/demo/jvm/HelloClassLoader.class
         *
         * 模拟条件：父类加载器找不到这个HelloClassLoader类（将该类注释掉，并将.class文件放到指定目录），就会执行我们自定义的类加载器
         * 输出结果：
         *         恩，是的，我是由 class MyClassLoader 加载进来的
         *         null
         */
        loadOrder();

        System.out.println("================");
        /**
         * 同一个类被不同加载器加载了，得到的Class对象是不同的
         * 输出结果：
         * 恩，是的，我是由 class sun.misc.Launcher$AppClassLoader 加载进来的
         * file:/D:/a/workspace/Alliswell/JavaDemo/target/classes/org/a/demo/jvm/HelloClassLoader.class
         * D:\a\workspace\Alliswell\JavaDemo\target\classes\
         *
         * 恩，是的，我是由 class MyClassLoader2 加载进来的
         * file:/D:/a/workspace/Alliswell/JavaDemo/target/classes/org/a/demo/jvm/HelloClassLoader.class
         *
         * 恩，是的，我是由 class sun.misc.Launcher$AppClassLoader 加载进来的
         * file:/D:/a/workspace/Alliswell/JavaDemo/target/classes/org/a/demo/jvm/HelloClassLoader.class
         *
         * HelloClassLoader.class.isAssignableFrom(clazz0): true
         * HelloClassLoader.class.isAssignableFrom(clazz1): false
         * HelloClassLoader.class.isAssignableFrom(clazz2): true
         * clazz0 == clazz1: false
         * clazz0 == clazz2: true
         * clazz1 == clazz2: false
         * clazz0.equals(clazz1): false
         * clazz0.equals(clazz2): true
         * clazz1.equals(clazz2): false
         * obj0 instanceof HelloClassLoader: true
         * obj1 instanceof HelloClassLoader: false
         * obj2 instanceof HelloClassLoader: true
         */
        diffLoader();

        System.out.println("================");
        threadLoader();

        /**
         * SPI 参见 {@link SPITest}
         * SPI 全称为 (Service Provider Interface) ,是JDK内置的一种服务提供发现机制。
         */
//        ServiceLoader
    }

    /**
     * 类加载器双亲委派模型：如果一个类加载器收到类加载的请求，它首先不会自己去尝试加载这个类，而是把这个请求委派给父类加载器完成。
     * 每个类加载器都是如此，只有当父加载器在自己的搜索范围内找不到指定的类时（即ClassNotFoundException），子加载器才会尝试自己去加载。
     *
     * @throws Exception
     */
    public static void loadOrder() throws Exception {
        MyClassLoader classLoader = new MyClassLoader("D:\\a\\workspace\\Alliswell\\JavaDemo\\src\\main\\resources\\");
        Class clazz1 = classLoader.loadClass("alliswell.demo.jvm.HelloClassLoader");
        Object obj1 = clazz1.newInstance();
        Method helloMethod = clazz1.getDeclaredMethod("hello", null);
        helloMethod.invoke(obj1, null);
        System.out.println(classLoader.getSystemResource("alliswell/demo/jvm/HelloClassLoader.class"));
    }

    /**
     * 破坏双亲委派模型方式一:自定义类加载器MyClassLoader2，重写loadClass方法
     * 我们可以使用这种方式来验证下结论：同一个类被不同加载器加载了，得到的Class对象是不同的
     *
     * @throws Exception
     */
    public static void diffLoader() throws Exception {
        //MyClassLoader加载HelloClassLoader类
        MyClassLoader classLoader0 = new MyClassLoader("D:\\a\\workspace\\Alliswell\\JavaDemo\\src\\main\\resources\\");
        Class clazz0 = classLoader0.loadClass("alliswell.demo.jvm.HelloClassLoader");
        Object obj0 = clazz0.newInstance();
        Method helloMethod0 = clazz0.getDeclaredMethod("hello", null);
        helloMethod0.invoke(obj0, null);
        System.out.println(classLoader0.getSystemResource("alliswell/demo/jvm/HelloClassLoader.class"));
        //MyClassLoader2加载HelloClassLoader类
        MyClassLoader2 classLoader = new MyClassLoader2("D:\\a\\workspace\\Alliswell\\JavaDemo\\src\\main\\resources\\");
        Class clazz1 = classLoader.loadClass("alliswell.demo.jvm.HelloClassLoader");
        Object obj1 = clazz1.newInstance();
        Method helloMethod = clazz1.getDeclaredMethod("hello", null);
        helloMethod.invoke(obj1, null);
        System.out.println(classLoader.getSystemResource("alliswell/demo/jvm/HelloClassLoader.class"));
        //AppClassLoader加载HelloClassLoader类
        ClassLoader loader = Test.class.getClassLoader();
        Class clazz2 = loader.loadClass("alliswell.demo.jvm.HelloClassLoader");
        Object obj2 = clazz2.newInstance();
        helloMethod = clazz2.getDeclaredMethod("hello", null);
        helloMethod.invoke(obj2, null);
        System.out.println(loader.getSystemResource("alliswell/demo/jvm/HelloClassLoader.class"));

        System.out.println("HelloClassLoader.class.isAssignableFrom(clazz0): " + HelloClassLoader.class.isAssignableFrom(clazz0));
        System.out.println("HelloClassLoader.class.isAssignableFrom(clazz1): " + HelloClassLoader.class.isAssignableFrom(clazz1));
        System.out.println("HelloClassLoader.class.isAssignableFrom(clazz2): " + HelloClassLoader.class.isAssignableFrom(clazz2));
        System.out.println("clazz0 == clazz1: " + (clazz0 == clazz1));
        System.out.println("clazz0 == clazz2: " + (clazz0 == clazz2));
        System.out.println("clazz1 == clazz2: " + (clazz1 == clazz2));
        System.out.println("clazz0.equals(clazz1): " + clazz0.equals(clazz1));
        System.out.println("clazz0.equals(clazz2): " + clazz0.equals(clazz2));
        System.out.println("clazz1.equals(clazz2): " + clazz1.equals(clazz2));
        System.out.println("obj0 instanceof HelloClassLoader: " + (obj0 instanceof HelloClassLoader));
        System.out.println("obj1 instanceof HelloClassLoader: " + (obj1 instanceof HelloClassLoader));
        System.out.println("obj2 instanceof HelloClassLoader: " + (obj2 instanceof HelloClassLoader));
    }

    /**
     * 破坏双亲委派模型方式二:使用线程上下文类加载器
     */
    private static void threadLoader() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
                Class clazz1 = null;
                try {
                    clazz1 = classLoader.loadClass("alliswell.demo.jvm.HelloClassLoader");
                    Object obj1 = clazz1.newInstance();
                    Method helloMethod = clazz1.getDeclaredMethod("hello", null);
                    helloMethod.invoke(obj1, null);
                    System.out.println(classLoader.getSystemResource("alliswell/demo/jvm/HelloClassLoader.class"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        // 线程上下文加载器
        t.setContextClassLoader(new MyClassLoader2(""));
        t.start();
    }
}

