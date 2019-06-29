/**
 * @Title: SimpleFactoryCalculator
 * @Package org.org.alliswell.calculator.simplefactory
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2016/11/24 21:06
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package alliswell.calculator.simplefactory;

import alliswell.calculator.originalimprove.operation.Operation;

import java.util.Scanner;

/**
 * @author alliswell008
 * @ClassName: SimpleFactoryCalculator
 * @Description: TODO(用一句话来说明)
 * @date 2016/11/24 21:06
 */
public class SimpleFactoryCalculator {
    // 可配置的提示语句，实现客户端样式与客户端数据的分离
    private static String ps_A = "请输入数字A：\n";
    private static String ps_B = "请输入数字B：\n";
    private static String ps_R = "计算器运算结果：\n";
    private static String ps_OP = "请输入运算符【+、-、*、/】：\n";// 扩展除法时，增加字符"/"

    /**
     * 简单工厂计算器，将客户端和运算逻辑分离，使得客户端不再对具体的运算逻辑依赖，只依赖与操作工厂。
     * 在增加一个除法运算时，只需要增加一个继承自操作类的除法类，即使除法类中存在运行时异常也不会影响到其他运算的正常计算
     * ;另一方面，对于客户端来说，可以不做修改
     *
     * @Title: client_简单工厂
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author org.alliswell
     * @throws
     */
    public static void client_SimpleFactory() {
        System.out.print(ps_A);
        Scanner s = new Scanner(System.in);
        int operationA = s.nextInt();
        System.out.print(ps_OP);
        s = new Scanner(System.in);
        String operation = s.nextLine();
        System.out.print(ps_B);
        s = new Scanner(System.in);
        int operationB = s.nextInt();
        int opRulst = 0;

        Operation op = OperationSimpleFactory.createOperate(operation);
        op.setOperationA(operationA);
        op.setOperationB(operationB);
        opRulst = op.getResult();

        System.out.print(ps_R+opRulst);
    }
}
