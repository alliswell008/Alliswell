package alliswell.pattern.creational.factory;

/**
 * TODO 功能描述
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
