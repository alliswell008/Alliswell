package alliswell.demo.classdemo;

/**
 * @Title: AbstractClass
 * @Package alliswell.demo.classdemo
 * @Description: 抽象类既可以继承非抽象类，也可以实现接口
 * @Author Administrator
 * @CreateDate 2019/5/20 15:56
 * @Version V1.0
 * <p>
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
public abstract class AbstractClass extends NonAbstractClass implements InterfaceClass {

    //抽象方法不能被static或synchronized修饰
//    abstract static synchronized void isAbstractClass();

    // 静态方法会被继承，但子类不能重写静态方法；当子类也存在该静态方法时，子类调用时称父类中的静态方法被“隐藏”
    static synchronized void isAbstractClassStaticMethod() {
        System.out.println("AbstractClassStaticMethod");
    }

    final synchronized void isAbstractClassFinalMethod() {
        System.out.println("AbstractClassFinalMethod");
    }

    @Override
    public void isInterfaceClass() {
        System.out.println("InterfaceClass");
    }
}

class Test extends AbstractClass {
    public static void main(String[] args) {
        // 多态：子类对象指向父类引用
        AbstractClass test = new Test();
        test.isNonAbstractClass();
        test.isInterfaceClass();
        test.isAbstractClassFinalMethod();

        // 静态方法可以被继承，但不会存在多态效果
        test.isAbstractClassStaticMethod();
        AbstractClass.isAbstractClassStaticMethod();
        // 当子类不重写时能证明子类可以被继承，当子类重写时父类方法会被“隐藏”而调用子类的静态方法
        Test.isAbstractClassStaticMethod();
    }

    //@Override 静态方法能继承，能重写但没有多态效果
    static synchronized void isAbstractClassStaticMethod() {
        System.out.println("SubAbstractClassStaticMethod");
    }

    //final方法能继承，但不能重写，子类重写的方法编译器不允许，必须被去掉
//    synchronized void isAbstractClassFinalMethod() {
//        System.out.println("AbstractClass2");
//    }
}
