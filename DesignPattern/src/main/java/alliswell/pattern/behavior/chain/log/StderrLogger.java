package alliswell.pattern.behavior.chain.log;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/4
 */
public class StderrLogger extends Logger {
    public StderrLogger(int mask) {
        super(mask);
    }

    @Override
    protected void writeMessage(String msg) {
        System.err.println("Sending to stderr: " + msg);
    }
}
