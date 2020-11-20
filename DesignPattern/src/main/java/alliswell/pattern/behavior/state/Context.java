package alliswell.pattern.behavior.state;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/10
 */
public class Context {

    private State state;

    public Context(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
        System.out.println("转换状态："+state.getClass().getSimpleName());
    }

    public void request() {
        System.out.println("当前状态："+state.getClass().getSimpleName());
        state.handle(this);
    }
}
