/**
 * @Title: Ware
 * @Package org.alliswell.shop.mo
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2017/1/17 12:18
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package alliswell.shop.mo;

/**
 * @author alliswell008
 * @ClassName: Ware
 * @Description: 商品
 * @date 2017/1/17 12:18
 */
public abstract class Ware {
    String name;			// 商品名
    double sprice;	// 商品价

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name 要设置的 name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return sprice
     */
    public double getSprice() {
        return sprice;
    }

    /**
     * @param sprice 要设置的 sprice
     */
    public void setSprice(double sprice) {
        this.sprice = sprice;
    }

    /**
     * <p>Title: </p>
     * <p>Description: </p>
     * @author alliswell
     */
    public Ware() {
        // TODO Auto-generated constructor stub
    }

    /**
     * <p>Title: </p>
     * <p>Description: </p>
     * @author alliswell
     */
    public Ware(String name) {
        // TODO Auto-generated constructor stub
        this.name = name;
    }

    public abstract void add(Ware c);
    public abstract void remove(Ware c);
    public abstract double display(int depth);// 获取商品的总价格
}
