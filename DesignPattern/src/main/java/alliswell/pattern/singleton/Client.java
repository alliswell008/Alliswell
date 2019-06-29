/**  
 * @Title:  Client.java
 * @Package 单例模式
 * @Description: TODO(用一句话描述该文件做什么)
 * @author alliswell
 * @date  2016-8-3 下午6:19:57
 * @version V1.0  
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * ****************************************************
 */
package alliswell.pattern.singleton;

import java.lang.reflect.Constructor;

/**
 * @ClassName: Client
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author alliswell
 * @date 2016-8-3 下午6:19:57
 *
 */
public class Client {

	public static void main(String[] args) throws Exception {
//        getSingleton();
//        getSingletonStaticInnerClass();
        getThreadSingleton();
    }

    private static void getSingleton() throws Exception {
        // private构造方法不允许通过new来构造对象，只有非private的可以
//        Singleton singleton = new Singleton();
        Singleton singleton = new Singleton("xxx");

        // private构造方法通过反射构造对象，但需要设置访问权限setAccessible(true)
        Constructor<Singleton> con = Singleton.class.getDeclaredConstructor();
        con.setAccessible(true);
        Object obj = con.newInstance();
        System.out.println("使用constructor对象的newInstance方法创建对象的信息："
                + (obj instanceof Singleton));

        // 非private构造方法也是可以反射构造对象的
        Constructor<Singleton> con2 = Singleton.class.getDeclaredConstructor(String.class);
        Object obj2 = con2.newInstance("xxx");
        System.out.println("使用constructor对象的newInstance方法创建对象的信息："
                + (obj2 instanceof Singleton));

        // 通过getInstance方法获取的是单例对象
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        if (singleton1 == singleton2) {
            System.out.println("单例对象");
        }

        // 通过输出结果不难看出，反射构造的对象是一个新的对象，这违背了单例模式的初衷
        System.out.println("私有构造方法反射：     " + obj);
        System.out.println("非私有构造方法反射：   " + obj2);
        System.out.println("第一次getInstance方法：" + singleton1);
        System.out.println("第二次getInstance方法：" + singleton2);

    }


    private static void getSingletonStaticInnerClass() {
        Singleton singleton1 = Singleton.getInstance_staticInnerClass();
        Singleton singleton2 = Singleton.getInstance_staticInnerClass();
        if (singleton1 == singleton2) {
            System.out.println("单例对象");
        }
    }

    private static void getThreadSingleton() {
        MyThread[] mts = new MyThread[10];
        for(int i = 0 ; i < mts.length ; i++){
            mts[i] = new MyThread();
        }

        for (int j = 0; j < mts.length; j++) {
            mts[j].start();
        }
    }

}

class MyThread extends Thread{

    @Override
    public void run() {
        // 饿汉模式 可以保证单例
//        System.out.println(Singleton.getInstance().hashCode());
        // 懒汉模式 会出现不同实例
//        System.out.println(Singleton.getInstance_lazy().hashCode());
        // 懒汉模式改进 通过静态内部类
//        System.out.println(Singleton.getInstance_staticInnerClass().hashCode());
        System.out.println(Singleton.getInstance_enum().hashCode());
    }
}
