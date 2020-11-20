package alliswell.pattern.behavior.memento;

/**
 * 备忘录
 *
 * @author chengxs
 * @date 2020/11/18
 */
public class Memento {
    /**
     * 要备忘的属性，可以是多个
     */
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
