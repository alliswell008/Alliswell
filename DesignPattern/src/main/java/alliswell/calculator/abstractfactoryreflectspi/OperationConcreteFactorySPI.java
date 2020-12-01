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
package alliswell.calculator.abstractfactoryreflectspi;

import alliswell.calculator.originalimprove.operation.Operation;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author alliswell008
 * @ClassName: OperationConcreteFactory
 * @Description: TODO(用一句话来说明)
 * @date 2016/11/24 21:22
 */
public class OperationConcreteFactorySPI extends OperationAbstractFactory {
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
        ServiceLoader loaders = ServiceLoader.load(Operation.class);
        for (Object loader : loaders) {
            boolean equals = loader.getClass().getName().equals(className);
            if (equals) {
                return (Operation) loader;
            }
        }
        return op;
    }
}
