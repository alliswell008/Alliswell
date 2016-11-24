/**
 * @Title: Calculator
 * @Package org.org.alliswell.calculator
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2016/11/24 20:41
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package org.alliswell.calculator;

import org.alliswell.calculator.original.OriginalCalculator;
import org.alliswell.calculator.originalimprove.OriginalImproveCalculator;
import org.alliswell.calculator.simplefactory.SimpleFactoryCalculator;
import org.alliswell.calculator.simplefactoryreflect.SimpleReflectFactoryCalculator;

/**
 * @author alliswell008
 * @ClassName: Calculator
 * @Description: 在控制台中实现计算器功能，可以完成加、减、乘（除法作为扩展的需求功能），
 * @date 2016/11/24 20:41
 */
public class CalculatorMain {

    public static void main(String[] args) {
        System.out.println("需求说明：");
        System.out.println("1.先实现加法、减法、乘法运算");
        System.out.println("2.现要求增加一个除法运算");
        System.out.println("3.实现GUI客户端，使用awt、swing或swt");

        System.out.println("\n原始计算器：");
        OriginalCalculator.client_Original(); // 已经满足需求1。但当增加需求2时，不满足面向对象的思想和开闭原则。

        System.out.println("\n原始改进计算器：");
        OriginalImproveCalculator.client_OriginalImprove(); // 以面向对象的思想，我将可能会变化的运算操作抽象出来，但在增加除法运算时仍不满足开闭原则。

        System.out.println("\n简单工厂计算器：");
        SimpleFactoryCalculator.client_SimpleFactory(); // 使用简单工厂，我将计算器客户端和运算操作逻辑分离出来，在增加除法运算时除了增加除法操作类外，仍要修改简单工厂类（增加case/if的判断）。

        System.out.println("\n简单工厂_反射计算器：");
        SimpleReflectFactoryCalculator.client_SimpleReflectFactory(); // 使用简单工厂和反射，消除了简单工厂类中的case/if判断，通过配置操作类的key-value来创建具体操作类。
//
//        System.out.println("\n抽象工厂_反射计算器：");
//        抽象工厂_反射计算器.client_抽象工厂_反射(); // 使用抽象工厂和反射，可以配置工厂类和操作类的key-value来创建具体操作类。

        System.out.println("\n运行结束...");
    }
}
