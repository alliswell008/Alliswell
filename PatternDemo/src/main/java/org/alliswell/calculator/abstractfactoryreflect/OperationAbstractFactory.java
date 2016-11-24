/**
 * @Title: OperationAbstractFactory
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
package org.alliswell.calculator.abstractfactoryreflect;

import org.alliswell.calculator.originalimprove.operation.Operation;

/**
 * @author alliswell008
 * @ClassName: OperationAbstractFactory
 * @Description: TODO(用一句话来说明)
 * @date 2016/11/24 21:21
 */
public abstract class OperationAbstractFactory {
    public abstract Operation createInstance(String className);
}
