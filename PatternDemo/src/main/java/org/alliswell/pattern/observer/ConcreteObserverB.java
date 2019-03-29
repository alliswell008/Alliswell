/**
 * @Title: Observer
 * @Package org.alliswell.pattern.observer
 * @Description: TODO(用一句话来说�?)
 * @author alliswell008
 * @date 2017/1/17 10:57
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
 * @ClassName: Observer
 * @Description: TODO(用一句话来说�?)
 * @date 2017/1/17 10:57
 */
public class ConcreteObserverB implements Observer {
    public String name;

    public ConcreteObserverB(String n){
        name=n;
    }

    @Override
    public void update(String state) {

    }

    @Override
    public void update(Boss boss) {
        System.out.println(name+" update new state: boss "+boss.getState());
    }
}
