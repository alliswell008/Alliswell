/**
 * @Title: CashRegisterMain
 * @Package org.org.alliswell.cashregister
 * @Description: 商场收银
 * @author alliswell008
 * @date 2016/11/24 21:29
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package src.main.java.org.alliswell.cashregister;

import org.alliswell.cashregister.original.OriginalCashRegister;
import org.alliswell.cashregister.simplefactory.SimpleFactoryCashRegister;
import org.alliswell.cashregister.strategy.StrategyCashRegistor;
import org.alliswell.cashregister.strategysimplefactory.StategySimpleFactoryCashRegister;

/**
 * @author alliswell008
 * @ClassName: CashRegisterMain
 * @Description: 商场收银
 * @date 2016/11/24 21:29
 */
public class CashRegisterMain {
    public static void main(String[] args) {
        System.out.println("�?求说明：");
        System.out.println("1.先实现原总价、打八折、打五折、满20元减10�?");
        System.out.println("2.现要求增加一个满200元减100�?");
        System.out.println("3.现要求增加一个买1�?1");
        System.out.println("4.实现GUI客户端，使用awt、swing或swt");

        OriginalCashRegister.acceptCash();
		SimpleFactoryCashRegister.acceptCash();
        StrategyCashRegistor.acceptCash();
        StategySimpleFactoryCashRegister.acceptCash();
    }
}
