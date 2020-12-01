package alliswell.pattern.creational.factory.factory;

import alliswell.pattern.creational.factory.IProduct;
import alliswell.pattern.creational.factory.ProductA;

/**
 * 具体工厂
 *
 * @author chengxs
 * @date 2020/11/16
 */
public class FactoryA implements IFactory {
    @Override
    public IProduct getProduct() {
        return new ProductA();
    }
}
