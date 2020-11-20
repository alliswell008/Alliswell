package alliswell.pattern.creational.builder.product;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/16
 */
public class Director {
    public void createProduct(Builder builder) {
        builder.buildPartA();
        builder.buildPartB();
    }
}
