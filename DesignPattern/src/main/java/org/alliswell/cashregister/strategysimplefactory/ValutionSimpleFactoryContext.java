/**
 * @Title: ValutionSimpleFactoryContext
 * @Package org.alliswell.cashregister.strategysimplefactory
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2016/11/25 0:20
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package org.alliswell.cashregister.strategysimplefactory;

import org.alliswell.cashregister.strategy.valution.CovertPrice;
import org.alliswell.cashregister.strategy.valution.OriginalPrice;
import org.alliswell.cashregister.strategy.valution.ReducePrice;
import org.alliswell.cashregister.strategy.valution.Valution;

/**
 * @author alliswell008
 * @ClassName: ValutionSimpleFactoryContext
 * @Description: 策略简单工厂是对策略上下文的改造
 * @date 2016/11/25 0:20
 */
public class ValutionSimpleFactoryContext {
    private Valution category; // 较之简单工厂，多了这个策略对象，这也就是简单工厂和策略上下文的区别

    /**
     * <p>
     * Title:
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @author alliswell
     */
    public ValutionSimpleFactoryContext(String costStrategy) {
        double rebate = 0.8;
        double fullMoney = 20;
        double backMoney = 10;

        switch (costStrategy) {
            case "打八折":
                rebate = 0.8;
                this.category = new CovertPrice(rebate);// 打八折
                break;
            case "满20减10":
                fullMoney = 20;
                backMoney = 10;
                this.category = new ReducePrice(fullMoney, backMoney);// 满fullMoney减backMoney
                break;
            case "满200减100":
                fullMoney = 200;
                backMoney = 100;
                this.category = new ReducePrice(fullMoney, backMoney);// 满fullMoney减backMoney
                break;

            default:
                this.category = new OriginalPrice();// 原价
                break;
        }
    }

    public double ContextInterface(double money) {
        return category.getResult(money);
    }
}
