package alliswell.pattern.structural.facade;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/23
 */
public class Facade {
    SubSystemOne one;
    SubSystemTwo two;
    SubSystemThree three;
    SubSystemFour four;

    public Facade() {
        one = new SubSystemOne();
        two = new SubSystemTwo();
        three = new SubSystemThree();
        four = new SubSystemFour();
    }

    public void methodA() {
        System.out.println("方法组A()---");
        one.methodOne();
        two.methodTwo();
        four.methodFour();
    }

    public void methodB() {
        System.out.println("方法组B()---");
        two.methodTwo();
        three.methodThree();
    }
}
