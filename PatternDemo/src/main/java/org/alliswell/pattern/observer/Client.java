/**
 * @Title: Client
 * @Package org.alliswell.pattern.observer
 * @Description: TODO(用一句话来说�?)
 * @author alliswell008
 * @date 2017/1/17 11:07
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package src.main.java.org.alliswell.pattern.observer;

/**
 * @author alliswell008
 * @ClassName: Client
 * @Description: 观察者模式消除了具体观察者和具体主题（需要被观察的抽象类）之间的相互持有，只�?要持有父类引用即�?
 * @date 2017/1/17 11:07
 */
public class Client {

    public static void main(String[] args) {
        ConcreteSubjectA subject = new ConcreteSubjectA();
        Observer o1 = new ConcreteObserverA("张山");
        Observer o2 = new ConcreteObserverA("李四");
        subject.addObserver(o1);
        subject.addObserver(o2);
        System.out.println("准备:");
        subject.setState("上班�?");
        subject.change();
        subject.setState("下班�?");
        subject.change();

        ConcreteSubjectB subject2 = new ConcreteSubjectB();
        Observer o11 = new ConcreteObserverB("张山");
        Observer o22 = new ConcreteObserverB("李四");
        subject2.addObserver(o11);
        subject2.addObserver(o22);
        System.out.println("准备:");
        subject2.setBoss(new Boss("来了"));
        subject2.change();
        subject2.setBoss(new Boss("走了"));
        subject2.change();
    }
}
