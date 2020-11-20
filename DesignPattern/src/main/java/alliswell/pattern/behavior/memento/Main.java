package alliswell.pattern.behavior.memento;

/**
 * 看管人
 *
 * @author chengxs
 * @date 2020/11/18
 */
public class Main {
    public static void main(String[] args) {
        Originatior o = new Originatior();
        // 发起人初始状态
        o.setState("on");
        o.show();

        Caretaker c= new Caretaker();
        // 发起人生成备忘录
        Memento memento = o.createMemento();
        // 将备忘录交给看管人
        c.setMemento(memento);

        // 发起人状态改变
        o.setState("off");
        o.show();

        // 用看管人的备忘录恢复发起人的状态
        o.setMemento(c.getMemento());
        o.show();
    }
}
