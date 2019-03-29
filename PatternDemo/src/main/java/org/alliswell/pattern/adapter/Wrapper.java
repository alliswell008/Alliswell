package org.alliswell.pattern.adapter;

import org.alliswell.pattern.adapter.original.Adaptee;

/**
 * 对象适配器：
 */
public class Wrapper implements Targetable {

    // 直接关联被适配类
    private Adaptee adaptee;

    // 可以通过构造函数传入具体需要适配的被适配类对象
    public Wrapper (Adaptee adaptee) {
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
