package alliswell.pattern.behavior.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/17
 */
abstract class Iterator {
    public abstract Object first();

    public abstract Object next();

    public abstract boolean isDone();

    public abstract Object currentItem();
}

abstract class Aggregate {
    public abstract Iterator createIterator();
}

class ConcreteAggregate extends Aggregate {

    private List<Object> items = new ArrayList<>(10);

    public Object get(int index) {
        return items.get(index);
    }

    public void set(int index, Object item) {
        this.items.add(index,item);
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator();
    }

    public int count() {
        return items.size();
    }


}

class ConcreteIterator extends Iterator {

    private ConcreteAggregate aggregate;
    private int current = 0;

    public ConcreteIterator() {
    }

    public ConcreteIterator(ConcreteAggregate aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public Object first() {
        return aggregate.get(0);
    }

    @Override
    public Object next() {
        Object ret = null;
        current++;
        if (current < aggregate.count()) {
            ret = aggregate.get(current);
        }
        return ret;
    }

    @Override
    public boolean isDone() {
        return current >= aggregate.count() ? true : false;
    }

    @Override
    public Object currentItem() {
        return aggregate.get(current);
    }
}
