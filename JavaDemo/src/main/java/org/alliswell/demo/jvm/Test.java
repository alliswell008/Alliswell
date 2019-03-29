package org.alliswell.demo.jvm;

import java.lang.reflect.Method;

public class Test {

    public static void main(String args[]) throws Exception {
        // 类加载器双亲委派模型：如果一个类加载器收到类加载的请求，它首先不会自己去尝试加载这个类，而是把这个请求委派给父类加载器完成。
        // 每个类加载器都是如此， 只有当父加载器在自己的搜索范围内找不到指定的类时（即ClassNotFoundException），
        // 子加载器才会尝试自己去加载。
        MyClassLoader classLoader = new MyClassLoader("E:\\workspace_todo\\git\\Alliswell\\JavaDemo\\src\\main\\resources");
        Class clazz = classLoader.loadClass("org.alliswell.demo.jvm.GetClassLoader");
        Object obj = clazz.newInstance();
        Method helloMethod = clazz.getDeclaredMethod("hello", null);
        helloMethod.invoke(obj, null);
    }
}

// 输出结果：
// 恩，是的，我是由 class sun.misc.Launcher$AppClassLoader 加载进来的
// 模拟父类加载器找不到这个类（删除这个类，这里把这个类注释掉），就会执行我们自定义的类加载器
// 恩，是的，我是由 class org.alliswell.demo.jvm.MyClassLoader 加载进来的