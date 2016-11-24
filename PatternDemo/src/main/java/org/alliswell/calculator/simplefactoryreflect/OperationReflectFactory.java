/**
 * @Title: OperationReflectFactory
 * @Package org.org.alliswell.calculator.simplefactoryreflect
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2016/11/24 21:13
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package org.alliswell.calculator.simplefactoryreflect;

import org.alliswell.calculator.originalimprove.operation.Operation;

/**
 * @author alliswell008
 * @ClassName: OperationReflectFactory
 * @Description: TODO(用一句话来说明)
 * @date 2016/11/24 21:13
 */
public class OperationReflectFactory {
    /**
     * 简单工厂+反射
     * 对比未用反射的创建方法，反射后的代码实现了简单工厂的修改关闭，即添加新的操作时不用增加case/if判断，只需增加相应的key-value配置
     * @Title: createOperate_反射
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author org.alliswell
     * @param className
     * @return
     * @throws
     */
    public static Operation createOperate(String className) {
        Operation op = null;
        try {
            op = (Operation) Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return op;
    }
}
