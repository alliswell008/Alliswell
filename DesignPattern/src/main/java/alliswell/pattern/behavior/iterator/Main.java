package alliswell.pattern.behavior.iterator;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/17
 */
public class Main {
    public static void main(String[] args) {
        ConcreteAggregate a = new ConcreteAggregate();
        a.set(0, "大鸟");
        a.set(1, "小菜");
        a.set(2, "行李");
        a.set(3, "老外");
        a.set(4, "公交内部成员");
        a.set(5, "小偷");

        Iterator i = new ConcreteIterator(a);
        Object item = i.first();
        while (!i.isDone()) {
            System.out.println(String.format("%s请买车票！", i.currentItem()));
            i.next();
        }
    }
}
