/**
 * @Title: OperationFactory
 * @Package org.org.alliswell.calculator.simplefactory
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2016/11/24 21:07
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package alliswell.calculator.simplefactory;

import alliswell.calculator.originalimprove.operation.Addition;
import alliswell.calculator.originalimprove.operation.Division;
import alliswell.calculator.originalimprove.operation.Multiplication;
import alliswell.calculator.originalimprove.operation.Operation;
import alliswell.calculator.originalimprove.operation.Subtraction;

/**
 * @author alliswell008
 * @ClassName: OperationFactory
 * @Description: TODO(用一句话来说明)
 * @date 2016/11/24 21:07
 */
public class OperationSimpleFactory {
    /**
     * 简单工厂+switch/if
     * @Title: createOperate
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author org.alliswell
     * @param operation
     * @return
     * @throws
     */
    public static Operation createOperate(String operation) {
        Operation op = null;
        switch (operation) {
            case "+":
                op = new Addition();
                break;
            case "-":
                op = new Subtraction();
                break;
            case "*":
                op = new Multiplication();
                break;
            case "/":
                op = new Division();
                break;
        }

        return op;
    }
}
