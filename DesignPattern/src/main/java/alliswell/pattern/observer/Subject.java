/**
 * @Title: Subject
 * @Package org.alliswell.pattern.observer
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2017/1/17 10:58
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package alliswell.pattern.observer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author alliswell008
 * @ClassName: Subject
 * @Description: TODO(用一句话来说明)
 * @date 2017/1/17 10:58
 */
public class Subject {
    /**
     * 观察者名单
     */
    private List<Observer> list = new LinkedList<>();
    /**
     * 注册观察者
     * @param o 观察者
     */
    public void addObserver(Observer o){
        list.add(o);
    }
    /**
     * 删除观察者
     * @param o 观察者
     */
    public void deleteObserver(Observer o){
        int i = list.indexOf(o);
        if (i>-1) {
            list.remove(i);
        }
    }
    /**
     * 通知观察者
     */
    public void notifyObservers(String state){
        for (Observer o:list) {
            o.update(state);
        }
    }

    /**
     * 通知观察者
     */
    public void notifyObservers(Boss boss){
        for (Observer o:list) {
            o.update(boss);
        }
    }
}
