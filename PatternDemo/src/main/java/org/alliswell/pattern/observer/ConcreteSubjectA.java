/**
 * @Title: Subject
 * @Package org.alliswell.pattern.observer
 * @Description: TODO(用一句话来说�?)
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
package src.main.java.org.alliswell.pattern.observer;

/**
 * @author alliswell008
 * @ClassName: Subject
 * @Description: TODO(用一句话来说�?)
 * @date 2017/1/17 10:58
 */
public class ConcreteSubjectA extends Subject {
    /**
     * 状�??
     */
    public String state;
    /**
     * 状�?�是否改变的标志
     */
    public boolean isChanged = false;

    /**
     * 状�?�改变后，�?�知观察�?
     */
    public void change() {
        if (isChanged) {
            this.notifyObservers(state);
        }
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        isChanged = true;
    }

    public boolean isChanged() {
        return isChanged;
    }

    public void setChanged(boolean isChanged) {
        this.isChanged = isChanged;
    }
}
