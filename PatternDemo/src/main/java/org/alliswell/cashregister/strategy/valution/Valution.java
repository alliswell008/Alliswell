/**
 * @Title: Valution
 * @Package org.alliswell.cashregister.strategy.valution
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2016/11/24 22:17
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
 * @ClassName: Valution
 * @Description: TODO(用一句话来说明)
 * @date 2016/11/24 22:17
 */
public abstract class Valution {
    // 计价算法
    public abstract double getResult(double money);
}
