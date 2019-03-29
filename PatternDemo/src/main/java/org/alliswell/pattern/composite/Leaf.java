/**
 * @Title: Leaf
 * @Package org.alliswell.pattern.singleton.composite
 * @Description: TODO(用一句话来说�?)
 * @author alliswell008
 * @date 2017/1/17 10:23
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package src.main.java.org.alliswell.pattern.composite;

/**
 * @ClassName: Leaf
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author alliswell
 * @date 2016-8-3 下午5:28:10
 *
 */
public class Leaf extends Compenent {

    /**
     * <p>Title: </p>
     * <p>Description: </p>
     * @author alliswell
     * @param name
     */
    public Leaf(String name) {
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
    }

}

