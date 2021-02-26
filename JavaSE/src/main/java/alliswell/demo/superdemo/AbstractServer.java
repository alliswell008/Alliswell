package alliswell.demo.superdemo;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2021/1/21
 */
public abstract class AbstractServer {
    public void init() {
        throw new RuntimeException();
    }

    public void doSomething() {
        System.out.println("ok");

        init();
    }
}
