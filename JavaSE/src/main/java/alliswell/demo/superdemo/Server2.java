package alliswell.demo.superdemo;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2021/1/21
 */
public class Server2 extends AbstractServer {

    @Override
    public void doSomething() {
        super.doSomething();
    }

    @Override
    public void init() {
        System.out.println("init2");
    }

    public static void main(String[] args) {
        new Server2().doSomething();
    }
}
