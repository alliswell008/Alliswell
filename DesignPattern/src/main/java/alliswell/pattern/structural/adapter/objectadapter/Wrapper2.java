package alliswell.pattern.structural.adapter.objectadapter;

import alliswell.pattern.structural.adapter.Targetable;
import alliswell.pattern.structural.adapter.original.Adaptee2;

/**
 * 对象适配器：通过持有被适配对象，可以调用被适配对象的方法
 */
public class Wrapper2 implements Targetable {

    /**
     * 直接关联被适配类对象
     */
    private Adaptee2 adaptee;

    /**
     * 可以通过构造函数传入具体需要适配的被适配类对象
     *
     * @param adaptee 被适配类对象
     */
    public Wrapper2(Adaptee2 adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        // 这里是使用委托的方式完成特殊功能
        this.adaptee.specificRequest();
    }

    @Override
    public void request2() {
        this.adaptee.specificRequest3();
    }
}
