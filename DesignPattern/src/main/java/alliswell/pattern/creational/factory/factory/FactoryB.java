package alliswell.pattern.creational.factory.factory;

import alliswell.pattern.creational.factory.IProduct;
import alliswell.pattern.creational.factory.ProductB;

/**
 * 具体工厂
 *
 * @author chengxs
 * @date 2020/11/16
 */
public class FactoryB implements IFactory {
    @Override
    public IProduct getProduct() {
        return new ProductB();
    }
}
