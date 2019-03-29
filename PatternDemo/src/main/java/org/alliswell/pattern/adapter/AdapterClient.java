package org.alliswell.pattern.adapter;

import org.alliswell.pattern.adapter.original.Adaptee;

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
        adapter.request();
        adapter.request2();

        // 对象适配器
        // 要先创建一个被适配类的对象作为参数
        Targetable adapter2 = new Wrapper(new Adaptee());
        adapter2.request();

        // 接口适配器
        IAdapteeSub1 adapteeSub1 = new IAdapteeSub1();
        IAdapteeSub2 adapteeSub2 = new IAdapteeSub2();
        adapteeSub1.method1();
        adapteeSub1.method2();
        adapteeSub2.method1();
        adapteeSub2.method2();
    }
}
