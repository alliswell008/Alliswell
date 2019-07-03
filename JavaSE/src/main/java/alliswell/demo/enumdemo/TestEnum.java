package alliswell.demo.enumdemo;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2019/7/1
 */
public class TestEnum {

    public static void main(String[] args) {
        System.out.println(EnumDemo.State.start);
        System.out.println(EnumDemo.State.start.getPrivateValue());
        System.out.println(EnumDemo.State.start.getPublicValue());
        // 枚举类是类的内部类时私有的属性也可以直接访问，在外部时私有属性不能直接访问
//        System.out.println(EnumDemo.State.start.privateValue);
        System.out.println(EnumDemo.State.start.publicValue);
    }
}
