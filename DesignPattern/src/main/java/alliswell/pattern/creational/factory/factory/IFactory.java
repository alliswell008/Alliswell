package alliswell.pattern.creational.factory.factory;

import alliswell.pattern.creational.factory.IProduct;

/**
 * 抽象工厂
 *
 * @author chengxs
 * @date 2020/11/16
 */
public interface IFactory {
    public IProduct getProduct();
}
