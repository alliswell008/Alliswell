/**
 * @Title: ReducePrice
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
package org.alliswell.cashregister.strategy.valution;

/**
 * @author alliswell008
 * @ClassName: ReducePrice
 * @Description: TODO(用一句话来说明)
 * @date 2016/11/24 22:18
 */
public class ReducePrice extends Valution {
    private double moneyCondition = 0d;
    private double moneyReturn = 0d;

    /**
     * <p>Title: </p>
     * <p>Description: </p>
     * @author alliswell
     */
    public ReducePrice(double moneyCondition, double moneyReturn) {
        // TODO Auto-generated constructor stub
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
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
        return money >= moneyCondition ? money - moneyReturn : money;
    }
}
