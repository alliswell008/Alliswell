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
 * @Description: 利用枚举实现单例
 * @author alliswell
 * @date 2016-8-3 下午6:16:32
 *
 */
public class Singleton_enum implements Serializable {

    private Singleton_enum(){}

    public static Singleton_enum getInstance(){

        // @Test start 为测试多线程单例是否有效，模拟创建实例之前的耗时工作
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // @Test end 为测试多线程单例是否有效，模拟创建实例之前的耗时工作

        return Single.instance.getInstance();
    }

    // 枚举
    //枚举enum和静态代码块的特性相似，在使用枚举时，构造方法会被自动调用，利用这一特�?�也可以实现单例
    private static enum Single {
        instance;

        private  Singleton_enum single;
        //JVM会保证此方法绝对只调用一�?
        private Single(){
            single = new Singleton_enum();
        }

        public Singleton_enum getInstance(){
            return single;
        }
    }
}
