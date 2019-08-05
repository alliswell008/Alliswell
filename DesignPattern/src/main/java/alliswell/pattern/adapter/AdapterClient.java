package alliswell.pattern.adapter;

import alliswell.pattern.adapter.classadapter.Adapter;
import alliswell.pattern.adapter.classadapter.Adapter2;
import alliswell.pattern.adapter.interfaceadapter.IAdapterSub1;
import alliswell.pattern.adapter.interfaceadapter.IAdapterSub2;
import alliswell.pattern.adapter.objectadapter.Wrapper;
import alliswell.pattern.adapter.objectadapter.Wrapper2;
import alliswell.pattern.adapter.original.Adaptee;
import alliswell.pattern.adapter.original.Adaptee2;

/**
 * 适配器模式：
 * 1、类适配器：AdapterClient类要使用Adaptee类中的具体方法，但Adaptee类中的方法并不适用于AdapterClient类，
 *      而适配器模式就可以对Adaptee类中的方法进行修饰和包装
 *
 * 2、对象适配器：适配器类持有Adaptee类型的属性，通过构造方法给此属性赋值
 *
 * 3、接口适配器：适配器类实现IAdaptee接口，并将适配器类定义为抽象类，这样具体适配器就只需要继承这个抽象类
 *      且只要重写当前适配器关注的方法而不需要重写不必要的方法
 *
 */
public class AdapterClient {

    public static void main(String[] args) {
        // 类适配器
        Targetable adapter = new Adapter();
        classAdapter(adapter);
        adapter = new Adapter2();
        classAdapter(adapter);

        // 对象适配器
        // 要先创建一个被适配类的对象作为参数
        Targetable adapter2 = new Wrapper(new Adaptee());
        adapter2.request2();
        adapter2 = new Wrapper2(new Adaptee2());
        adapter2.request2();

        // 接口适配器
        Targetable adapteeSub1 = new IAdapterSub1();
        Targetable adapteeSub2 = new IAdapterSub2();
        adapteeSub1.request();
        adapteeSub1.request2();
        adapteeSub2.request();
        adapteeSub2.request2();
    }

    public static void classAdapter(Targetable adapter) {
        adapter.request();
        adapter.request2();
    }
}
