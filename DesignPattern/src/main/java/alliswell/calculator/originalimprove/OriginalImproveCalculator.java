/**
 * @Title: OriginalImproveCalculator
 * @Package org.org.alliswell.calculator.originalimprove
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2016/11/24 20:51
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package alliswell.calculator.originalimprove;

import alliswell.calculator.originalimprove.operation.Addition;
import alliswell.calculator.originalimprove.operation.Division;
import alliswell.calculator.originalimprove.operation.Multiplication;
import alliswell.calculator.originalimprove.operation.Operation;
import alliswell.calculator.originalimprove.operation.Subtraction;

import java.util.Scanner;

/**
 * @author alliswell008
 * @ClassName: OriginalImproveCalculator
 * @Description: TODO(用一句话来说明)
 * @date 2016/11/24 20:51
 */
public class OriginalImproveCalculator {
    // 可配置的提示语句，实现客户端样式与客户端数据的分离
    private static String ps_A = "请输入数字A：\n";
    private static String ps_B = "请输入数字B：\n";
    private static String ps_R = "计算器运算结果：\n";
    private static String ps_OP = "请输入运算符【+、-、*、/】：\n";// 扩展除法时，增加字符"/"

    /**
     * 相对原始计算器来说，虽分离了具体运算逻辑，但仍存在依赖具体运算的情况。
     * @Title: client_原始改进
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author org.alliswell
     * @throws
     */
    public static void client_OriginalImprove() {
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

        // System.out.print(1 / 0);

        // 具体的操作对象，客户端也是不需要关心的，计算结果才是需要的。还要改进
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
                System.out.print(1 / 0); // **手动模拟运行时异常，此时的运行异常也不会影响其他运算
                op = new Division();
                break;
        }

        op.setOperationA(operationA);
        op.setOperationB(operationB);
        opRulst = op.getResult();

        System.out.print(ps_R+opRulst);
    }
}
