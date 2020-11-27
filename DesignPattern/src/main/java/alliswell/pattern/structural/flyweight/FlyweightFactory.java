package alliswell.pattern.structural.flyweight;

import java.util.Hashtable;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/23
 */
public class FlyweightFactory {
    private Hashtable flyweights = new Hashtable();

    public FlyweightFactory() {
        flyweights.put("X", new ConcreteFlyweight());
        flyweights.put("Y", new ConcreteFlyweight());
        flyweights.put("Z", new ConcreteFlyweight());
    }

    public Flyweight getFlyweight(String key) {
        return (Flyweight) flyweights.get(key);
    }
}
