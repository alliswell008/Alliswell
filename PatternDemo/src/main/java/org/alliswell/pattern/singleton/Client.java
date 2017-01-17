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
package org.alliswell.pattern.singleton;

/**
 * @ClassName: Client
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author alliswell
 * @date 2016-8-3 下午6:19:57
 *
 */
public class Client {

	public static void main(String[] args) {
		Singleton singleton1 = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();

        if (singleton1 == singleton2) {
            System.out.println("单例对象");
        }
	}
}
