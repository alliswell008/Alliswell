package alliswell.pattern.behavior.vistor;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/18
 */
public class Main {
    public static void main(String[] args) {
        ObjectStructure os = new ObjectStructure();
        os.attach(new ConcreteElementA());
        os.attach(new ConcreteElementB());

        ConcreteVisitor1 v1 = new ConcreteVisitor1();
        ConcreteVisitor2 v2 = new ConcreteVisitor2();

        os.accept(v1);
        os.accept(v2);
    }
}
