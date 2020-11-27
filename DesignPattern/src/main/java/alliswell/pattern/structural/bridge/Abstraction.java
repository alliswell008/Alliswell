package alliswell.pattern.structural.bridge;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/23
 */
public abstract class Abstraction {
    protected Implementor implementor;

    public void setImplementor(Implementor implementor) {
        this.implementor = implementor;
    }

    public void operation() {
        implementor.operation();
    }
}
