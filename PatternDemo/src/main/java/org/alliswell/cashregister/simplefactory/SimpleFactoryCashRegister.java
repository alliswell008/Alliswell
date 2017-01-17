/**
 * @Title: SimpleFactoryCashRegister
 * @Package org.org.alliswell.cashregister.simplefactory
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2016/11/24 21:33
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package org.alliswell.cashregister.simplefactory;

import org.alliswell.cashregister.simplefactory.valution.Valution;

import java.util.Scanner;

/**
 * @author alliswell008
 * @ClassName: SimpleFactoryCashRegister
 * @Description: TODO(用一句话来说明)
 * @date 2016/11/24 21:33
 */
public class SimpleFactoryCashRegister {
    private static String ps_单价 = "单价：\n";
    private static String ps_数量 = "数量：\n";
    private static String ps_计算方式 = "计算方式：\n";
    private static String ps_总计 = "总计：\n";

    public static void acceptCash(){
        System.out.print(ps_单价);
        Scanner s = new Scanner(System.in);
        int 单价 = s.nextInt();
        System.out.print(ps_数量);
        s = new Scanner(System.in);
        int 数量 = s.nextInt();
        System.out.print(ps_计算方式);
        s = new Scanner(System.in);
        String 计算方式 = s.nextLine();
        double 总计 = 0;

        Valution op = ValutionSimpleFactory.createValution(计算方式);
        op.set单价(单价);
        op.set数量(数量);

        总计 = op.get总价();
        System.out.print(ps_总计 + 总计);
    }
}
