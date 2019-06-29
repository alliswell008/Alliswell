/**
 * @Title: OperationConcreteFactory
 * @Package org.org.alliswell.calculator.abstractfactoryreflect
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2016/11/24 21:22
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

/**
 * @author alliswell008
 * @ClassName: OperationConcreteFactory
 * @Description: TODO(用一句话来说明)
 * @date 2016/11/24 21:22
 */
public class OperationConcreteFactory extends OperationAbstractFactory {
    /* (非 Javadoc)
    * <p>Title: createInstance/p>
    * <p>Description: </p>
    * @param operation
    * @return
    * @see 简单工厂模式.抽象操作工厂#createInstance(java.lang.String)
    */
    @Override
    public Operation createInstance(String className) {
        // TODO Auto-generated method stub
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
