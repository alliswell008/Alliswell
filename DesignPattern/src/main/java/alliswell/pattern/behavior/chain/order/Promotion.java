package alliswell.pattern.behavior.chain.order;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/25
 */
public abstract class Promotion {
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
