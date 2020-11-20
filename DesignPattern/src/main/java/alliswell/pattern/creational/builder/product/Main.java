package alliswell.pattern.creational.builder.product;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/16
 */
public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        ConcreteBuilder1 b1 = new ConcreteBuilder1();
        ConcreteBuilder2 b2 = new ConcreteBuilder2();

        director.createProduct(b1);
        Product p1 = b1.getResult();
        p1.show();

        director.createProduct(b2);
        Product p2 = b2.getResult();
        p2.show();
    }
}
