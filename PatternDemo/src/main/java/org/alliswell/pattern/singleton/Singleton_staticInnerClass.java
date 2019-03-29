/**  
 * @Title:  Singleton.java
 * @Package 单例模式
 * @Description: TODO(用一句话描述该文件做�?�?)
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
package src.main.java.org.alliswell.pattern.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @ClassName: Singleton
 * @Description: 利用静�?�内部类实现单例
 * @author alliswell
 * @date 2016-8-3 下午6:16:32
 *
 */
public class Singleton_staticInnerClass implements Serializable {

    private static class SingletonHolder {
        public static Singleton_staticInnerClass instance = new Singleton_staticInnerClass();
    }

    private Singleton_staticInnerClass() {

    }

    // 静�?�内部类
    public static Singleton_staticInnerClass getInstance() {
        // @Test start 为测试多线程单例是否有效，模拟创建实例之前的耗时工作
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // @Test end 为测试多线程单例是否有效，模拟创建实例之前的耗时工作
        return Singleton_staticInnerClass.SingletonHolder.instance;
    }

    // 反序列化单例对象
    //该方法在反序列化时会被调用，该方法不是接口定义的方法，有点儿约定俗成的感�?
    protected Object readResolve() throws ObjectStreamException {
        System.out.println("调用了readResolve方法�?");
        return Singleton_staticInnerClass.SingletonHolder.instance;
    }
}
