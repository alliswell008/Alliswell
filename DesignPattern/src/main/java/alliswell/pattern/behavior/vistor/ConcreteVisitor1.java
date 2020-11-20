package alliswell.pattern.behavior.vistor;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/18
 */
public class ConcreteVisitor1 extends Visitor {
    @Override
    public void visitConcreteElementA(ConcreteElementA concreteElementA) {
        System.out.println(String.format("%s被%s访问", concreteElementA.getClass().getTypeName(), this.getClass().getTypeName()));
        concreteElementA.operationA();
    }

    @Override
    public void visitConcreteElementB(ConcreteElementB concreteElementB) {
        System.out.println(String.format("%s被%s访问", concreteElementB.getClass().getTypeName(), this.getClass().getTypeName()));
        concreteElementB.operationB();
    }
}
