package alliswell.pattern.adapter.interfaceadapter;

import alliswell.pattern.adapter.Targetable;

public class IAdapterSub1 extends IAdapterWrapper implements Targetable {

    @Override
    public void request() {
        this.method1();
    }

    @Override
    public void request2() {

    }

    @Override
    public void method1() {
        System.out.println("the sourceable interface's first Sub1!");
    }
}
