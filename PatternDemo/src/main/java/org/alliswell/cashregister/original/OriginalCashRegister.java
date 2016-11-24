/**
 * @Title: OriginalCashRegister
 * @Package org.org.alliswell.cashregister.original
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2016/11/24 21:31
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package org.alliswell.cashregister.original;

import java.util.Scanner;

/**
 * @author alliswell008
 * @ClassName: OriginalCashRegister
 * @Description: TODO(用一句话来说明)
 * @date 2016/11/24 21:31
 */
public class OriginalCashRegister {
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

        switch (计算方式) {
            case "打八折":
                总计 = 单价 * 数量 * 0.8;
                break;
            case "打五折":
                总计 = 单价 * 数量 * 0.5;
                break;
            case "满20元减10元":
                总计 = 单价 * 数量;
                总计 = 总计 > 20 ? (总计 - 10) : 总计 ;
                break;
            default:
                总计 = 单价 * 数量;
                break;
        }

        System.out.print(ps_总计 + 总计);
    }
}
