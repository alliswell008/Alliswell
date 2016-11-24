/**
 * @Title: ValutionSimpleFactory
 * @Package org.org.alliswell.cashregister.simplefactory
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2016/11/24 21:35
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package org.alliswell.cashregister.simplefactory;

import org.alliswell.cashregister.simplefactory.valution.*;

/**
 * @author alliswell008
 * @ClassName: ValutionSimpleFactory
 * @Description: TODO(用一句话来说明)
 * @date 2016/11/24 21:35
 */
public class ValutionSimpleFactory {
    /**
     * 简单工厂+switch/if
     * @Title: createOperate
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author org.alliswell
     * @param operation
     * @return
     * @throws
     */
    public static Valution create计价方式(String 计算方式) {
        Valution op = null;
        switch (计算方式) {
            case "打八折":
                op = new CovertEightPrice();
                break;
            case "打五折":
                op = new CovertFivePrice();
                break;
            case "满20元减10元":
                op = new ReducePrice20to10();
                break;
            case "满200元减100元":
                op = new ReducePrice200to100();// 需求2，增加case判断，并增加一个“满200元减100元的方式”
                break;
            default:
                op = new OriginalPrice();
                break;
        }

        return op;
    }
}
