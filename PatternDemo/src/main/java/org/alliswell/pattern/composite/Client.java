/**  
 * @Title:  Client.java
 * @Package 组合模式
 * @Description: TODO(用一句话描述该文件做什么)
 * @author alliswell
 * @date  2016-8-3 下午5:36:02
 * @version V1.0  
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * ****************************************************
 */
package org.alliswell.pattern.composite;

/**
 * @ClassName: Client
 * @Description: Client是面向Leaf和Composite的基类Compenent编程的，Client不区分操作Leaf和Composite
 * 满足依赖倒置原则
 * @author alliswell
 * @date 2016-8-3 下午5:36:02
 *
 */
public class Client {

	public static void main(String[] args) {
		Composite root = new Composite("root");
		root.add(new Leaf("leaf1"));
		root.add(new Leaf("leaf2"));
		
		Composite composite1 = new Composite("composite1");
		Composite composite2 = new Composite("composite2");
		root.add(composite1);
		composite1.add(composite2);
		
		composite1.add(new Leaf("leaf11"));
		composite1.add(new Leaf("leaf12"));
		
		composite2.add(new Leaf("leaf21"));
		composite2.add(new Leaf("leaf22"));
		
		root.display(1);
	}
}