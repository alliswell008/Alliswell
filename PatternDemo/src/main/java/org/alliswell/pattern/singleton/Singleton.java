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

/**
 * @ClassName: Singleton
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author alliswell
 * @date 2016-8-3 下午6:16:32
 *
 */
public class Singleton {
	
	private static Singleton singleton = null;
	
	private Singleton(){
		
	}
	
	public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
