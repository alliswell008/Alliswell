package alliswell.pattern.structural.proxy;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/20
 */
public class RealSubject extends Subject {
    @Override
    public void request() {
        System.out.println("真实的请求");
    }
}
