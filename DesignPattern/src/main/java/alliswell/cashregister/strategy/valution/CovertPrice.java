/**
 * @Title: CovertPrice
 * @Package org.alliswell.cashregister.strategy.valution
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2016/11/24 22:18
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package alliswell.cashregister.strategy.valution;

/**
 * @author alliswell008
 * @ClassName: CovertPrice
 * @Description: TODO(用一句话来说明)
 * @date 2016/11/24 22:18
 */
public class CovertPrice extends Valution {
    private double moneyRebate = 1d;

    /**
     * <p>Title: </p>
     * <p>Description: </p>
     * @author alliswell
     */
    public CovertPrice(double moneyRebate) {
        // TODO Auto-generated constructor stub
        this.moneyRebate = moneyRebate;
    }
    /* (非 Javadoc)
     * <p>Title: acceptCashAlgorithm</p>
     * <p>Description: </p>
     * @param money
     * @return
     * @see 商场收银软件.计价策略.计价策略#acceptCashAlgorithm(double)
     */
    @Override
    public double getResult(double money) {
        // TODO Auto-generated method stub
        return money * moneyRebate;
    }
}
