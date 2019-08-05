package alliswell.pattern.adapter.interfaceadapter;

import alliswell.pattern.adapter.Targetable;

public class IAdapterSub2 extends IAdapterWrapper implements Targetable {

    @Override
    public void request() {

    }

    @Override
    public void request2() {
        this.method2();
    }

    @Override
    public void method2() {
        System.out.println("the sourceable interface's second Sub2!");
    }
}
