package alliswell.pattern.behavior.vistor;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/18
 */
public class ConcreteElementA extends Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteElementA(this);
    }

    public void operationA() {

    }
}
