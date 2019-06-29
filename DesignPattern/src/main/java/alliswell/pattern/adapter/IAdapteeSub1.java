package alliswell.pattern.adapter;

public class IAdapteeSub1 extends IAdapteeWrapper {

    @Override
    public void method1() {
        System.out.println("the sourceable interface's second Sub1!");
    }
}
