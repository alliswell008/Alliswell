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
 * @Description: 懒汉模式实现单例
 * @author alliswell
 * @date 2016-8-3 下午6:16:32
 *
 */
public class Singleton_lazy implements Serializable {

    // 单例对象私有，未实例�?
    private static Singleton_lazy singleton = null;

	// 构�?�方法私�?
	private Singleton_lazy(){

	}

    // 懒汉模式-1，线程不安全
    public static Singleton_lazy getInstance() {
        if (singleton == null) {
            // @Test start 为测试多线程单例是否有效，模拟创建实例之前的耗时工作
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // @Test end 为测试多线程单例是否有效，模拟创建实例之前的耗时工作
            singleton = new Singleton_lazy();
        }
        return singleton;
    }
}
