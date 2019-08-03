/**
 * @Title: SimpleFactoryReflectCalculator
 * @Package org.org.alliswell.calculator.simplefactoryreflect
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2016/11/24 21:12
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package alliswell.calculator.simplefactoryreflect;

import alliswell.calculator.originalimprove.operation.Operation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author alliswell008
 * @ClassName: SimpleFactoryReflectCalculator
 * @Description: TODO(用一句话来说明)
 * @date 2016/11/24 21:12
 */
public class SimpleReflectFactoryCalculator {
    // 可配置的提示语句，实现客户端样式与客户端数据的分离
    private static String ps_A = "请输入数字A：\n";
    private static String ps_B = "请输入数字B：\n";
    private static String ps_R = "计算器运算结果：\n";
    private static String ps_OP = "请输入运算符【+、-、*、/】：\n";// 扩展除法时，增加字符"/"

    // 可配置的操作符-操作类名字符串
    private static Map<String,String> map = new HashMap<String,String>();
    static {
        map.put("+", "Addition");
        map.put("-", "Subtraction");
        map.put("*", "Multiplication");
        map.put("/", "Division");  // 扩展除法时，增加key-value
    }

    /**
     * 反射的作用在于可以利用类名（类名是一个字符串）来创建对象。
     * 这样我们就可以将选择创建哪个对象的判断过程，采用key-value来配置（map、properities、mapper）
     * ，通过匹配key来选择类名字符串。如本文件开头定义的map。
     * @Title: client_简单工厂_反射
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author org.alliswell
     * @throws
     */
    public static void client_SimpleReflectFactory() {
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

        Operation op = OperationReflectFactory.createOperate(map.get(operation));
        op.setOperationA(operationA);
        op.setOperationB(operationB);
        opRulst = op.getResult();

        System.out.print(ps_R+opRulst);
    }
}
