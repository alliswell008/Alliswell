/**  
 * @Title:  Compenent.java
 * @Package 组合模式
 * @Description: TODO(用一句话描述该文件做�?�?)
 * @author alliswell
 * @date  2016-8-3 下午5:22:56
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
 * @ClassName: Compenent
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author alliswell
 * @date 2016-8-3 下午5:22:56
 *
 */
public abstract class Compenent {
	String name;
	
	/**
	 * <p>Title: </p>
	 * <p>Description: </p>
	 * @author alliswell
	 */
	public Compenent(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	public abstract void add(Compenent c);
	public abstract void remove(Compenent c);
	public abstract void display(int depth);
}
