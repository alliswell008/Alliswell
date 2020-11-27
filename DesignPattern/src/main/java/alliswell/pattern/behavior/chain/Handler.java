package alliswell.pattern.behavior.chain;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/25
 */
public abstract class Handler {
    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(int request);
}
