/**
 * @Title: OriginalCalculator
 * @Package org.org.alliswell.calculator.original
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2016/11/24 20:44
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package alliswell.calculator.original;

import java.util.Scanner;

/**
 * @author alliswell008
 * @ClassName: OriginalCalculator
 * @Description: TODO(用一句话来说明)
 * @date 2016/11/24 20:44
 */
public class OriginalCalculator {

    // 可配置的提示语句，实现客户端样式与客户端数据的分离
    private static String ps_A = "请输入数字A：\n";
    private static String ps_B = "请输入数字B：\n";
    private static String ps_R = "计算器运算结果：\n";
    // 扩展除法时，增加字符"/"
    private static String ps_OP = "请输入运算符【+、-、*、/】：\n";

    /**
     * 原始计算器，客户端的样式和运算逻辑耦合在一起，不能被复用。 在增加一个
     * 除法运算时， 需要修改的代码，如果出现运行时异常会造成其他运算的正常使用。
     *
     * @throws
     * @Title: client_原始
     * @Description: 以完成需求的功能为目的，把客户端显示数据、客户端显示样式、
     * 计算器运算逻辑都耦合在一起
     * @author org.alliswell
     */
    public static void client_Original() {
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

        // 修改代码时产生的运行时异常，现手动模拟，此时加法、减法、乘法都将不能正常运算
        // 根据本程序的实际情况，增加除法运算，其实不应在此处模拟运行时异常（应在下面的**处）
        // ，但根据开闭原则：对现有的类、方法修改关闭（因为可能会造成错误），故在此处模拟
        // System.out.println(1 / 0);

        // 具体的运算过程，其实对于客户端来说是不需要关心怎么计算的，只需要显示计算的结果。要改进
        switch (operation) {
            case "+":
                opRulst = operationA + operationB;
                break;
            case "-":
                opRulst = operationA - operationB;
                break;
            case "*":
                opRulst = operationA * operationB;
                break;
            case "/":
                // **手动模拟运行时异常，此时的运行异常也不会影响其他运算
                System.out.println(1 / 0);
                opRulst = operationA / operationB;
                break;
        }

        System.out.print(ps_R + opRulst);
    }
}
