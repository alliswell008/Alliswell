package alliswell.pattern.structural.flyweight;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/23
 */
public class ConcreteFlyweight extends Flyweight {
    @Override
    public void operation(int extrinsicstate) {
        System.out.println("具体Flyweight："+extrinsicstate);
    }
}
