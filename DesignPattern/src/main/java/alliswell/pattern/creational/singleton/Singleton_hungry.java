/**  
 * @Title:  Singleton.java
 * @Package 单例模式
 * @Description: TODO(用一句话描述该文件做什么)
 * @author a
 * @date  2016-8-3 下午6:16:32
 * @version V1.0  
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * ****************************************************
 */
package alliswell.pattern.creational.singleton;

import java.io.Serializable;

/**
 * @ClassName: Singleton
 * @Description: 饿汉模式实现单例
 * @author a
 * @date 2016-8-3 下午6:16:32
 *
 */
public class Singleton_hungry implements Serializable {

    // 单例对象私有，并实例化
	private static Singleton_hungry singleton = new Singleton_hungry();

	// 构造方法私有
	private Singleton_hungry(){
        singleton = getInstance();
	}

    // 饿汉模式
    public static Singleton_hungry getInstance() {
        // @Test start 为测试多线程单例是否有效，模拟创建实例之前的耗时工作
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // @Test end 为测试多线程单例是否有效，模拟创建实例之前的耗时工作
	    return singleton;
    }
}
