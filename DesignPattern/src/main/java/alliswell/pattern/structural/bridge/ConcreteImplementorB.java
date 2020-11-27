package alliswell.pattern.structural.bridge;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/23
 */
public class ConcreteImplementorB extends Implementor {
    @Override
    public void operation() {
        System.out.println("具体实现B的方法执行");
    }
}
