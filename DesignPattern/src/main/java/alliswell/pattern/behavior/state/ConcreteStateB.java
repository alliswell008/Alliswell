package alliswell.pattern.behavior.state;

/**
 * 具体状态B
 *
 * @author chengxs
 * @date 2020/11/10
 */
public class ConcreteStateB extends State {

    @Override
    public void handle(Context context){
        context.setState(new ConcreteStateA());
    }
}
