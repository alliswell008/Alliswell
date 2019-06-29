/**
 * @Title: StrategyCaseRegistor
 * @Package org.alliswell.cashregister.strategy
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
package alliswell.cashregister.strategy;

import alliswell.cashregister.strategy.valution.CovertPrice;
import alliswell.cashregister.strategy.valution.OriginalPrice;
import alliswell.cashregister.strategy.valution.ReducePrice;

import java.util.Scanner;

/**
 * @author alliswell008
 * @ClassName: StrategyCaseRegistor
 * @Description: TODO(用一句话来说明)
 * @date 2016/11/24 22:17
 */
public class StrategyCashRegistor {
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

        ValutionContext context = null;

        switch (costStrategy) {
            case "打八折":
                double rebate = 0.8;
                context = new ValutionContext(new CovertPrice(rebate));// 打八折
                break;
            case "满20减10":
                double fullMoney = 20;
                double backMoney = 10;
                context = new ValutionContext(new ReducePrice(fullMoney, backMoney));// 满fullMoney减backMoney
                break;

            default:
                context = new ValutionContext(new OriginalPrice());// 原价
                break;
        }

        总计 = context.ContextInterface(单价 * 数量);
        System.out.print(ps_总计 + 总计);
    }
}
