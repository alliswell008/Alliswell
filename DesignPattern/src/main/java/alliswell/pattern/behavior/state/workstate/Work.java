package alliswell.pattern.behavior.state.workstate;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/10
 */
public class Work {

    private WorkState current;
    private int hour;
    private boolean finish;

    public Work() {
        current = new ForenoonState();
    }

    public void setCurrent(WorkState current) {
        this.current = current;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public boolean getFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public void writeProgram() {
        current.writeProgram(this);
    }
}
