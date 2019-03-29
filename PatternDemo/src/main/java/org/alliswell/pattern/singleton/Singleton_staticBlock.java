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

import java.io.Serializable;

/**
 * @ClassName: Singleton
 * @Description: 利用静�?�内部类实现单例
 * @author alliswell
 * @date 2016-8-3 下午6:16:32
 *
 */
public class Singleton_staticBlock implements Serializable {

    // 单例对象私有，未实例�?
    private static Singleton_staticBlock singleton = null;

    // 构�?�方法私�?
    private Singleton_staticBlock(){

    }

    // 静�?�代码块
    public static Singleton_staticBlock getInstance() {
        // @Test start 为测试多线程单例是否有效，模拟创建实例之前的耗时工作
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // @Test end 为测试多线程单例是否有效，模拟创建实例之前的耗时工作
        return singleton;
    }

    // 懒汉模式-4，静态代码块优化懒汉模式
    // 静�?�代码块必须放在静�?�变量后面，否则会�?�成变量未实例化而出现NullException
    static {
        // 静�?�代码块也只执行�?次，在类加载时执行，相当于饿汉模�?
        singleton = new Singleton_staticBlock();
    }
}
