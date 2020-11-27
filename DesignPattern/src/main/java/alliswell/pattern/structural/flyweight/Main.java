package alliswell.pattern.structural.flyweight;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/23
 */
public class Main {
    public static void main(String[] args) {
        int extrinsicstate = 22;

        FlyweightFactory f = new FlyweightFactory();

        Flyweight fx = f.getFlyweight("X");
        fx.operation(--extrinsicstate);

        Flyweight fy = f.getFlyweight("Y");
        fx.operation(--extrinsicstate);

        Flyweight fz = f.getFlyweight("Z");
        fx.operation(--extrinsicstate);

        Flyweight uf = new UnsharedConcreteFlyweight();
        uf.operation(--extrinsicstate);
    }
}
