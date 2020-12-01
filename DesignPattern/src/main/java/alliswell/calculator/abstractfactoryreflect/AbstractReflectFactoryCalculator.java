/**
 * @Title: AbstractReflectFactoryCalculator
 * @Package org.org.alliswell.calculator.abstractfactoryreflect
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2016/11/24 21:21
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package alliswell.calculator.abstractfactoryreflect;

import alliswell.calculator.originalimprove.operation.Operation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author alliswell008
 * @ClassName: AbstractReflectFactoryCalculator
 * @Description: TODO(用一句话来说明)
 * @date 2016/11/24 21:21
 */
public class AbstractReflectFactoryCalculator {
    // 可配置的提示语句，实现客户端样式与客户端数据的分离
    private static String ps_A = "请输入数字A：\n";
    private static String ps_B = "请输入数字B：\n";
    private static String ps_R = "计算器运算结果：\n";
    private static String ps_OP = "请输入运算符【+、-、*、/】：\n";// 扩展除法时，增加字符"/"

    // 可配置的操作符-操作类名字符串
    private static Map<String,String> map = new HashMap<String,String>();
    static {
        map.put("+", "alliswell.calculator.originalimprove.operation.Addition");
        map.put("-", "alliswell.calculator.originalimprove.operation.Subtraction");
        map.put("*", "alliswell.calculator.originalimprove.operation.Multiplication");
        map.put("/", "alliswell.calculator.originalimprove.operation.Division");  // 扩展除法时，增加key-value
    }

    // 可配置的操作符-具体工厂标识
    private static Map<String,String> opmap = new HashMap<String,String>();
    static {
        opmap.put("+","具体操作工厂");
        opmap.put("-","具体操作工厂");
        opmap.put("*","具体操作工厂");
        opmap.put("/","具体操作工厂");  // 扩展除法时，增加key-value
    }
    // 可配置的具体工厂标识-具体操作工厂
    private static Map<String,String> fmap = new HashMap<String,String>();
    static {
        fmap.put("具体操作工厂", "alliswell.calculator.abstractfactoryreflect.OperationConcreteFactory");
    }

    /**
     *
     * @Title: client_抽象工厂_反射
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author org.alliswell
     * @throws
     */
    public static void client_抽象工厂_反射() {
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

        Operation op = null;
        try {
            op = ((OperationAbstractFactory)Class.forName(fmap.get(opmap.get(operation))).newInstance()).createInstance(map.get(operation));
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        op.setOperationA(operationA);
        op.setOperationB(operationB);
        opRulst = op.getResult();

        System.out.print(ps_R+opRulst);
    }
}
