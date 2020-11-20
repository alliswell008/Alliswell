package alliswell.pattern.creational.builder.product;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/16
 */
public abstract class Builder {
    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract <T> T getResult();
}
