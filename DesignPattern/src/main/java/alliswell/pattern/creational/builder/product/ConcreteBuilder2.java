package alliswell.pattern.creational.builder.product;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/16
 */
public class ConcreteBuilder2 extends Builder {

    private Product product = new Product();

    @Override
    public void buildPartA() {
        product.add("部件X");
    }

    @Override
    public void buildPartB() {
        product.add("部件Y");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
