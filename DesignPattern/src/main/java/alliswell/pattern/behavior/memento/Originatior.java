package alliswell.pattern.behavior.memento;

/**
 * 发起人
 *
 * @author chengxs
 * @date 2020/11/18
 */
public class Originatior {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    /**
     * 生成备忘录，备忘state属性
     *
     * @return
     */
    public Memento createMemento() {
        return new Memento(state);
    }

    /**
     * 从备忘录中恢复state属性
     *
     * @param memento
     */
    public void setMemento(Memento memento) {
        this.state = memento.getState();
    }

    public void show() {
        System.out.println("state=" + state);
    }
}
