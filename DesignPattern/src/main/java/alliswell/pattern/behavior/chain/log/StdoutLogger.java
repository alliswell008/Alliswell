package alliswell.pattern.behavior.chain.log;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/4
 */
public class StdoutLogger extends Logger {

    public StdoutLogger(int mask) {
        super(mask);
    }

    @Override
    protected void writeMessage(String msg) {
        System.out.println("Writing to stdout: " + msg);
    }
}
