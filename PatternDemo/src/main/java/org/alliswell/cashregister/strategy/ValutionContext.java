/**
 * @Title: ValutionContext
 * @Package org.alliswell.cashregister.strategy
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2016/11/24 22:16
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package org.alliswell.cashregister.strategy;


import org.alliswell.cashregister.strategy.valution.Valution;

/**
 * @author alliswell008
 * @ClassName: ValutionContext
 * @Description: TODO(用一句话来说明)
 * @date 2016/11/24 22:16
 */
public class ValutionContext {
    private Valution category; // 较之简单工厂，多了这个策略对象，这也就是简单工厂和策略上下文的区别

    /**
     * <p>Title: </p>
     * <p>Description: </p>
     * @author alliswell
     */
    public ValutionContext(Valution category) {
        // TODO Auto-generated constructor stub
        this.category = category;
    }

    public double ContextInterface(double money) {
        return category.getResult(money);
    }
}
