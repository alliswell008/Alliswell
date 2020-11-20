package alliswell.pattern.behavior.mediator;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/18
 */
public abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
}
