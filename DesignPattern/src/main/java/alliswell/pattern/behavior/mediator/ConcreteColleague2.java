package alliswell.pattern.behavior.mediator;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/18
 */
public class ConcreteColleague2 extends Colleague {
    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    public void send(String message) {
        mediator.send(message, this);
    }

    public void notify(String message) {
        System.out.println("同事2得到消息："+message);
    }
}
