package alliswell.pattern.behavior.chain.log;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/4
 */
public abstract class Logger {
    public static int ERR = 3;
    public static int NOTICE = 5;
    public static int DEBUG = 7;
    private int mask;

    // The next element in the chain of responsibility
    private Logger next;

    public Logger(int mask) {
        this.mask = mask;
    }

    public void setNext(Logger logger) {
        next = logger;
    }

    public void message(String msg, int priority) {
        if (priority <= mask) {
            writeMessage(msg);
        }
        if (next != null) {
            next.message(msg, priority);
        }
    }

    public void debug(String msg) {
        if (DEBUG <= mask) {
            writeMessage(msg);
        }
        if (next != null) {
            next.message(msg, DEBUG);
        }
    }

    public void notice(String msg) {
        if (NOTICE <= mask) {
            writeMessage(msg);
        }
        if (next != null) {
            next.message(msg, NOTICE);
        }
    }

    public void error(String msg) {
        if (ERR <= mask) {
            writeMessage(msg);
        }
        if (next != null) {
            next.message(msg, ERR);
        }
    }

    abstract protected void writeMessage(String msg);

}
