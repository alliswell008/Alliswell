/**
 * @Title: Subject
 * @Package org.alliswell.pattern.behavior.observer
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
package alliswell.pattern.behavior.observer;

/**
 * @author alliswell008
 * @ClassName: Subject
 * @Description: TODO(用一句话来说明)
 * @date 2017/1/17 10:58
 */
public class ConcreteSubjectB extends Subject {
    /**
     * 状态
     */
    public Boss boss;
    /**
     * 状态是否改变的标志
     */
    public boolean isChanged = false;

    /**
     * 状态改变后，通知观察者
     */
    public void change(){
        if (isChanged) {
            this.notifyObservers(boss);
        }
    }

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
        isChanged = true;
    }

    public boolean isChanged() {
        return isChanged;
    }

    public void setChanged(boolean isChanged) {
        this.isChanged = isChanged;
    }
}
