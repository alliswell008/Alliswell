package alliswell.pattern.structural.proxy;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/20
 */
public class Proxy extends Subject {
    RealSubject realSubject;
    @Override
    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        realSubject.request();
    }
}
