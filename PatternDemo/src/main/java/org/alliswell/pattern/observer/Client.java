/**
 * @Title: Client
 * @Package org.alliswell.pattern.observer
 * @Description: TODO(用一句话来说明)
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
package org.alliswell.pattern.observer;

/**
 * @author alliswell008
 * @ClassName: Client
 * @Description: TODO(用一句话来说明)
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
        subject.setState("上班了");
        subject.change();
        subject.setState("下班了");
        subject.change();

        ConcreteSubjectB subject2 = new ConcreteSubjectB();
        subject.addObserver(o1);
        subject.addObserver(o2);
        System.out.println("准备:");
        subject2.setBoss(new Boss("来了"));
        subject.change();
        subject2.setBoss(new Boss("走了"));
        subject.change();
    }
}
