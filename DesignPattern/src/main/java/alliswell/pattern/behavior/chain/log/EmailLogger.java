package alliswell.pattern.behavior.chain.log;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/4
 */
public class EmailLogger extends Logger {
    public EmailLogger(int mask) {
        super(mask);
    }

    @Override
    protected void writeMessage(String msg) {
        System.out.println("Sending via e-mail: " + msg);
    }
}
