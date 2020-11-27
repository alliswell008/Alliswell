package alliswell.pattern.structural.flyweight;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/23
 */
public class UnsharedConcreteFlyweight extends Flyweight {
    @Override
    public void operation(int extrinsicstate) {
        System.out.println("不共享的具体Flyweight："+extrinsicstate);
    }
}
