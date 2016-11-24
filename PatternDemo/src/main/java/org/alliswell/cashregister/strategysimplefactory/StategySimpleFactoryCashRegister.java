/**
 * @Title: StategySimpleFactoryCashRegister
 * @Package org.alliswell.cashregister.strategysimplefactory
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2016/11/25 0:19
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package org.alliswell.cashregister.strategysimplefactory;

import java.util.Scanner;

/**
 * @author alliswell008
 * @ClassName: StategySimpleFactoryCashRegister
 * @Description: 将switch/if语句移到策略简单工厂类中，消除了客户端和具体策略的耦合。
 *               但在增加满200减100时需要修改case语句，可以考虑再结合反射
 *               ，将具体计价策略和策略参数配置成key-value以替代case语句的修改。
 * @date 2016/11/25 0:19
 */
public class StategySimpleFactoryCashRegister {
    private static String ps_单价 = "单价：\n";
    private static String ps_数量 = "数量：\n";
    private static String ps_计算策略 = "计算策略：\n";
    private static String ps_总计 = "总计：\n";

    public static void acceptCash() {
        System.out.print(ps_单价);
        Scanner s = new Scanner(System.in);
        int 单价 = s.nextInt();
        System.out.print(ps_数量);
        s = new Scanner(System.in);
        int 数量 = s.nextInt();
        System.out.print(ps_计算策略);
        s = new Scanner(System.in);
        String costStrategy = s.nextLine();
        double 总计 = 0;

        ValutionSimpleFactoryContext context = new ValutionSimpleFactoryContext(costStrategy);
        总计 = context.ContextInterface(单价 * 数量);
        System.out.print(ps_总计 + 总计);
    }
}
