package alliswell.pattern.creational.factory;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/16
 */
public class TestFactory {
    public static void main(String[] args){

        // 简单工厂
        IProduct product1 = SimpleFactory.getProduct(1);

        // 工厂
        IFactory factory = new FactoryA();
        IProduct product =factory.getProduct();
        factory = new FactoryB();
        product =factory.getProduct();

        // 抽象工厂


    }
}
