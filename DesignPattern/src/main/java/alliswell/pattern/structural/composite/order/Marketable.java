package alliswell.pattern.structural.composite.order;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/23
 */
public interface Marketable {


    public abstract void add(Marketable ware);

    public abstract void remove(Marketable ware);

    public abstract double display(int depth);
}
