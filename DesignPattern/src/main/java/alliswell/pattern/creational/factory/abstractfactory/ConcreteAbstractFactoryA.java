package alliswell.pattern.creational.factory.abstractfactory;

import alliswell.pattern.creational.factory.IProduct;
import alliswell.pattern.creational.factory.ProductA;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/16
 */
public class ConcreteAbstractFactoryA implements IFactory {
    @Override
    public IProduct getProduct1() {
        return new ProductA();
    }

    @Override
    public IProduct2 getProduct2() {
        return new Product2A();
    }
}
