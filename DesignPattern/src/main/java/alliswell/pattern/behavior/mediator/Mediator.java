package alliswell.pattern.behavior.mediator;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/18
 */
public abstract class Mediator {
    public abstract void send(String message, Colleague colleague);
}
