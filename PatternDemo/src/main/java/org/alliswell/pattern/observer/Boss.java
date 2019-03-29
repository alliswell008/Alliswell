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

import java.util.LinkedList;
import java.util.List;

/**
 * @author alliswell008
 * @ClassName: Subject
 * @Description: TODO(用一句话来说�?)
 * @date 2017/1/17 10:58
 */
public class Boss {
    private String state;

    /**
     * <p>Title: </p>
     * <p>Description: </p>
     * @author alliswell
     */
    public Boss(String state) {
        this.state = state;
    }

    /**
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state 要设置的 state
     */
    public void setState(String state) {
        this.state = state;
    }
}
