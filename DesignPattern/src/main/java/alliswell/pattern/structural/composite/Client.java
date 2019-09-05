/**  
 * @Title:  Client.java
 * @Package ���ģʽ
 * @Description: TODO(��һ�仰�������ļ���ʲô)
 * @author alliswell
 * @date  2016-8-3 ����5:36:02
 * @version V1.0  
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * ****************************************************
 */
package alliswell.pattern.structural.composite;

/**
 * @ClassName: Client
 * @Description: Client������Leaf��Composite�Ļ���Compenent��̵ģ�Client�����ֲ���Leaf��Composite
 * ������������ԭ��
 * @author alliswell
 * @date 2016-8-3 ����5:36:02
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