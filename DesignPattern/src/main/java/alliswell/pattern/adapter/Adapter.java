package alliswell.pattern.adapter;

import alliswell.pattern.adapter.original.Adaptee;

/**
 * 类适配器：可以对被适配类中的方法进行增强或削弱。
 */
public class Adapter extends Adaptee implements Targetable {

    @Override
    public void request() {
        // 类适配器：使用方不需要被适配类的所有方法，只需要部分方法，就可以在Targetable中定义
        super.specificRequest();
        // 在Adapter中实现时可以对被适配类中的方法进行组合
        super.specificRequest2();
    }


    @Override
    public void request2() {
        // 新增方法功能
        System.out.println("被适配类具有新增方法功能");
    }

}
