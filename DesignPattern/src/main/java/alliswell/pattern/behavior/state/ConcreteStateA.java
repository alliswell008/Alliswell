package alliswell.pattern.behavior.state;

/**
 * 具体状态A
 *
 * @author chengxs
 * @date 2020/11/10
 */
public class ConcreteStateA extends State {

    @Override
    public void handle(Context context){
        context.setState(new ConcreteStateB());
    }
}
