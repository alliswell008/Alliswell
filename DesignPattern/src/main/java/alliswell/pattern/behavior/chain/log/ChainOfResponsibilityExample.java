package alliswell.pattern.behavior.chain.log;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/4
 */
public class ChainOfResponsibilityExample {

    private static Logger createChain() {
        // Build the chain of responsibility

        Logger logger = new StdoutLogger(Logger.DEBUG);

        Logger logger1 = new EmailLogger(Logger.NOTICE);
        logger.setNext(logger1);

        Logger logger2 = new StderrLogger(Logger.ERR);
        logger1.setNext(logger2);

        return logger;
    }

    public static void main(String[] args) {
        Logger chain = createChain();

        // Handled by StdoutLogger (level = 7)
        chain.debug("Entering function y.");

        // Handled by StdoutLogger and EmailLogger (level = 5)
        chain.notice("Step1 completed.");

        // Handled by all three loggers (level = 3)
        chain.error("An error has occurred.");
    }

}
