package alliswell.pattern.creational.factory;

import alliswell.pattern.creational.factory.abstractfactory.ConcreteAbstractFactoryA;
import alliswell.pattern.creational.factory.abstractfactory.ConcreteAbstractFactoryB;
import alliswell.pattern.creational.factory.abstractfactory.ConcreteAbstractFactoryBA;
import alliswell.pattern.creational.factory.abstractfactory.IProduct2;
import alliswell.pattern.creational.factory.factory.FactoryA;
import alliswell.pattern.creational.factory.factory.FactoryB;
import alliswell.pattern.creational.factory.factory.IFactory;
import alliswell.pattern.creational.factory.simple.SimpleFactory;

/**
 * 工厂模式，实现了客户端和具体产品之间的解耦
 *
 * @author chengxs
 * @date 2020/11/16
 */
public class TestFactory {
    public static void main(String[] args) {

        // 简单工厂
        IProduct product1 = SimpleFactory.getProduct(1);

        // 工厂：应对的是产品的变化
        IFactory factory = new FactoryA();
        IProduct product = factory.getProduct();
        // 扩展产品B，不需要改原来代码
        factory = new FactoryB();
        product = factory.getProduct();

        // 抽象工厂：应对的是产品组和产品的双重变化
        alliswell.pattern.creational.factory.abstractfactory.IFactory factory2 = new ConcreteAbstractFactoryA();
        IProduct product11 = factory2.getProduct1();
        // 扩展抽象产品IProduct2
        IProduct2 product2 = factory2.getProduct2();

        // 扩展抽象产品IProduct和抽象产品IProduct2的组合：B+2B
        factory2 = new ConcreteAbstractFactoryB();
        IProduct product12 = factory2.getProduct1();
        IProduct2 product21 = factory2.getProduct2();

        // 扩展抽象产品IProduct和抽象产品IProduct2的组合:B+2A
        factory2 = new ConcreteAbstractFactoryBA();
        IProduct product13 = factory2.getProduct1();
        IProduct2 product22 = factory2.getProduct2();
    }
}
