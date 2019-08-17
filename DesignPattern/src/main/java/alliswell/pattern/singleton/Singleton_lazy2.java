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
package alliswell.pattern.singleton;

import java.io.Serializable;

/**
 * @ClassName: Singleton
 * @Description: 懒汉模式实现单例
 * @author a
 * @date 2016-8-3 下午6:16:32
 *
 */
public class Singleton_lazy2 implements Serializable {

    // 单例对象私有，未实例化
    private static Singleton_lazy2 singleton = null;

	// 构造方法私有
	private Singleton_lazy2(){

	}

    // 懒汉模式-2，线程安全
    public static synchronized Singleton_lazy2 getInstance(){
        if(singleton == null ) {
            // @Test start 为测试多线程单例是否有效，模拟大对象创建时间
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // @Test end 为测试多线程单例是否有效，模拟大对象创建时间
            singleton = new Singleton_lazy2();
        }
        return singleton;
    }
}
