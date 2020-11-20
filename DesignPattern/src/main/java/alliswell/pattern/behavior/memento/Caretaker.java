package alliswell.pattern.behavior.memento;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/18
 */
public class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
