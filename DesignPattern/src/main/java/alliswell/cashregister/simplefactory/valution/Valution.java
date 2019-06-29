/**
 * @Title: Valution
 * @Package org.org.alliswell.cashregister.simplefactory.valution
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2016/11/24 21:37
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package alliswell.cashregister.simplefactory.valution;

/**
 * @author alliswell008
 * @ClassName: Valution
 * @Description: TODO(用一句话来说明)
 * @date 2016/11/24 21:37
 */
public abstract class Valution {
    int 单价;
    int 数量;
    String 计算方式;

    /**
     * @return 单价
     */
    public int get单价() {
        return 单价;
    }

    /**
     * @param 单价 要设置的 单价
     */
    public void set单价(int 单价) {
        this.单价 = 单价;
    }

    /**
     * @return 数量
     */
    public int get数量() {
        return 数量;
    }

    /**
     * @param 数量 要设置的 数量
     */
    public void set数量(int 数量) {
        this.数量 = 数量;
    }

    /**
     * @return 计算方式
     */
    public String get计算方式() {
        return 计算方式;
    }

    /**
     * @param 计算方式 要设置的 计算方式
     */
    public void set计算方式(String 计算方式) {
        this.计算方式 = 计算方式;
    }

    public abstract double get总价();
}
