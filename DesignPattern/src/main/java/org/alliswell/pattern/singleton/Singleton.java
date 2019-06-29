/**  
 * @Title:  Singleton.java
 * @Package 单例模式
 * @Description: TODO(用一句话描述该文件做什么)
 * @author alliswell
 * @date  2016-8-3 下午6:16:32
 * @version V1.0  
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * ****************************************************
 */
package org.alliswell.pattern.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @ClassName: Singleton
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author alliswell
 * @date 2016-8-3 下午6:16:32
 *
 */
public class Singleton implements Serializable {

	private static Singleton singleton = new Singleton();
    private static Singleton singleton_lazy = null;

	private Singleton(){

	}

    public Singleton(String name) {

    }

    // 饿汉模式
    public static Singleton getInstance() {
        if (singleton == null) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            singleton = new Singleton();
        }
        return singleton;
    }

    // 懒汉模式
    public static Singleton getInstance_lazy() {
        if (singleton_lazy == null) { //创建实例之前可能会有一些准备性的耗时工作
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            singleton_lazy = new Singleton();
        }
        return singleton_lazy;
    }

    // 静态内部类优化懒汉模式
    private static class SingletonHelper {
        // 静态变量只初始化一次，以此特性进行单例设置，在内部类被调用时执行起到了延时加载的作用
        private static Singleton singleton_lazy = new Singleton();
    }

    public static Singleton getInstance_staticInnerClass() {
        if (singleton_lazy == null) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            singleton_lazy = SingletonHelper.singleton_lazy;
        }
        return singleton_lazy;
    }

    // 静态代码块优化懒汉模式
//    static {
//        // 静态代码块也只执行一次，在类加载时执行，相当于饿汉模式
//        singleton_lazy = new Singleton();
//    }

    // 反序列化单例对象
    //该方法在反序列化时会被调用，该方法不是接口定义的方法，有点儿约定俗成的感觉
    protected Object readResolve() throws ObjectStreamException {
        System.out.println("调用了readResolve方法！");
        return SingletonHelper.singleton_lazy;
    }

    // 枚举实现单例模式
    private enum EnumSingleton{
        singletonFactory;

        private Singleton instance;

        //枚举enum和静态代码块的特性相似，在使用枚举时，构造方法会被自动调用，利用这一特性也可以实现单例
        private EnumSingleton(){//枚举类的构造方法在类加载是被实例化
            instance = new Singleton();
        }

        public Singleton getInstance(){
            return instance;
        }
    }

    public static Singleton getInstance_enum(){
        return EnumSingleton.singletonFactory.getInstance();
    }
}
