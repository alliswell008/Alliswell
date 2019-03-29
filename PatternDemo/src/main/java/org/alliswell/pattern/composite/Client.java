/**  
 * @Title:  Client.java
 * @Package 组合模式
 * @Description: TODO(用一句话描述该文件做�?�?)
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
package src.main.java.org.alliswell.pattern.composite;

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


		Composite composite2_1 = new Composite("composite2_1");
		Composite composite2_2 = new Composite("composite2_2");
		composite2.add(composite2_1);
		composite2.add(composite2_2);

		composite2_1.add(new Leaf("leaf2_11"));
		composite2_2.add(new Leaf("leaf2_12"));

		root.display(1);
	}
}