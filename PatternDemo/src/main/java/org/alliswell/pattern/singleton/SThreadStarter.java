/**  
 * @Title:  Client.java
 * @Package 单例模式
 * @Description: TODO(用一句话描述该文件做�?�?)
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
package src.main.java.org.alliswell.pattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: SThreadStarter
 * @Description: 单线程下�?7种单例模�?
 * @author alliswell
 * @date 2016-8-3 下午6:19:57
 *
 */
public class SThreadStarter {

	public static void main(String[] args) throws Exception {
//        getSingleton();
        getSingletonStaticInnerClass();
    }

    private static void getSingleton() throws Exception {
        // private构�?�方法不允许通过new来构造对象，只有非private的可�?
//        Singleton singleton = new Singleton();
        Singleton singleton = new Singleton("xxx");

        // private构�?�方法�?�过反射构�?�对象，但需要设置访问权限setAccessible(true)
        Constructor<Singleton> con = Singleton.class.getDeclaredConstructor();
        con.setAccessible(true);
        Object obj = con.newInstance();
        System.out.println("使用constructor对象的newInstance方法创建对象的信息："
                + (obj instanceof Singleton));

        // 非private构�?�方法也是可以反射构造对象的
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

        // 通过输出结果不难看出，反射构造的对象是一个新的对象，这违背了单例模式的初�?
        System.out.println("构�?�方法：     " + singleton);
        System.out.println("私有构�?�方法反射：     " + obj);
        System.out.println("非私有构造方法反射：   " + obj2);
        System.out.println("第一次getInstance方法�?" + singleton1);
        System.out.println("第二次getInstance方法�?" + singleton2);

    }

    private static void getSingletonStaticInnerClass() {
        Singleton singleton1 = Singleton.getInstance_staticInnerClass();
        Singleton singleton2 = Singleton.getInstance_staticInnerClass();
        if (singleton1 == singleton2) {
            System.out.println("单例对象");
        }
    }
}
