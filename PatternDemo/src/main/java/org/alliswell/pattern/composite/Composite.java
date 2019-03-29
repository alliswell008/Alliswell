/**  
 * @Title:  Composite.java
 * @Package 组合模式
 * @Description: TODO(用一句话描述该文件做�?�?)
 * @author alliswell
 * @date  2016-8-3 下午5:28:39
 * @version V1.0  
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * ****************************************************
 */
package src.main.java.org.alliswell.pattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Composite
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author alliswell
 * @date 2016-8-3 下午5:28:39
 *
 */
public class Composite extends Compenent {

    private List<Compenent> compenent = new ArrayList<>();

	/**
	 * <p>Title: </p>
	 * <p>Description: </p>
	 * @author alliswell
	 * @param name
	 */
	public Composite(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	/* (�? Javadoc)
	 * <p>Title: add</p>
	 * <p>Description: </p>
	 * @param c
	 * @see 组合模式.Compenent#add(组合模式.Compenent)
	 */
	@Override
	public void add(Compenent c) {
		// TODO Auto-generated method stub
		compenent.add(c);
	}

	/* (�? Javadoc)
	 * <p>Title: remove</p>
	 * <p>Description: </p>
	 * @param c
	 * @see 组合模式.Compenent#remove(组合模式.Compenent)
	 */
	@Override
	public void remove(Compenent c) {
		// TODO Auto-generated method stub
		compenent.remove(c);
	}

	/* (�? Javadoc)
	 * <p>Title: display</p>
	 * <p>Description: </p>
	 * @param c
	 * @see 组合模式.Compenent#display(组合模式.Compenent)
	 */
	@Override
	public void display(int depth) {
		// TODO Auto-generated method stub
		String sp = "";
		for (int j = 0; j < depth; j++) {
			sp += "-";
		}
		System.out.println(sp+this.name);
		for (Compenent c : compenent) {
			depth = depth + 2 ;
			c.display(depth);
			depth = depth - 2 ;
			
			//c.display(depth + 2);
		}
	}

}
