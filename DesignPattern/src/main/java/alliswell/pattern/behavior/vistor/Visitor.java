package alliswell.pattern.behavior.vistor;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/18
 */
public abstract class Visitor {
    public abstract void visitConcreteElementA(ConcreteElementA concreteElementA);
    public abstract void visitConcreteElementB(ConcreteElementB concreteElementB);
}
