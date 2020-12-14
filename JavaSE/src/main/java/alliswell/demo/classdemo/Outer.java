package alliswell.demo.classdemo;

/**
 * 匿名内部类必须继承或实现一个已有的接口
 */
interface Service {
    void method();
}

/**
 * 内部类，在Java中，可以将一个类的定义放在另外一个类的定义内部，内部类本身就是类的一个属性，与其他属性定义方式一致。
 * 可以分为四种：成员内部类、局部内部类、匿名内部类和静态内部类。
 * </p>
 * 内部类的优点 我们为什么要使用内部类呢？因为它有以下优点：
 * <ul>
 * <li>一个内部类对象可以访问创建它的外部类对象的内容，包括私有数据！</li>
 * <li>内部类不为同一包的其他类所见，具有很好的封装性；
 * <li>内部类有效实现了“多重继承”，优化 java 单继承的缺陷。
 * <li>匿名内部类可以很方便的定义回调。
 * </ul>
 * 内部类有哪些应用场景
 * <ul>
 * <li>一些多算法场合
 * <li>解决一些非面向对象的语句块。
 * <li>适当使用内部类，使得代码更加灵活和富有扩展性。
 * <li>当某个类除了它的外部类，不再被其他的类使用时。
 * </ul>
 *
 * @author chengxs
 * @date 2020/12/11
 */
public class Outer {
    /**
     * 外部类私有静态成员变量
     */
    private static int radius = 1;
    /**
     * 外部类私有成员变量
     */
    private int age = 12;

    public static void main(String[] args) {
        // 内部类
        Outer.Inner in = new Outer().new Inner();
        in.print();

        // 局部内部类
        new Outer().outMethod();

        // 静态内部类
        Outer.StaticInner inner = new Outer.StaticInner();
        inner.visit();

        // 匿名内部类
        new Outer().test(1);
    }

    /**
     * 局部内部类，定义在方法中的内部类
     * 定义在实例方法中的局部类可以访问外部类的所有变量和方法，定义在静态方法中的局部类只能访问外部类的静态变量和方法。
     * 局部内部类的创建方式，在对应方法内，new 内部类()
     */
    void outMethod() {
        int a = 10;
        class Inner {
            void innerMethod() {
                System.out.println("局部内部类 " + a);
            }

        }
        // 默认final修饰，不允许在【局部内部类】里修改的
        // a ++;
        new Inner().innerMethod();
    }

    /**
     * 匿名内部类就是没有名字的内部类，日常开发中使用的比较多。
     *
     * <p>除了没有名字，匿名内部类还有以下特点：
     * <ul>
     *     <li>匿名内部类必须继承一个抽象类或者实现一个接口。</li>
     *     <li>匿名内部类不能定义任何静态成员和静态方法。</li>
     *     <li>当所在的方法的形参需要被匿名内部类使用时，必须声明为 final。</li>
     *     <li>匿名内部类不能是抽象的，它必须要实现继承的类或者实现的接口的所有抽象方法。</li>
     * </ul>
     * </p>
     *
     * @param i 默认局部变量i是final修饰的（可以省略final），是不允许在【局部内部类】里修改的
     */
    private void test(final int i) {
        new Service() {
            @Override
            public void method() {
                // Variable 'i' is accessed from within inner class, needs to be final or effectively final
                for (int j = 0; j < i; j++) {
                    age++;
                    /**
                     * 匿名类（也是一种局部内部类）之外的局部变量i因为<b>生命周期不一致</b>，局部变量直接存储在栈中，当方法执行结束后，
                     * 非final的局部变量就被销毁。而局部内部类对局部变量的引用依然存在，如果局部内部类要调用局部变量时，就会出错。
                     * 所以默认局部变量i是final修饰的（可以省略final），是不允许在【局部内部类】里修改的
                     */
                    // i ++;
                    System.out.println("匿名内部类 " + i);
                }
            }
        }.method();
    }

    /**
     * 静态内部类，定义在类内部的静态类
     * 静态内部类可以访问外部类所有的静态变量，而不可访问外部类的非静态变量；静态内部类的创建方式，new 外部类.静态内部类()
     */
    static class StaticInner {
        public void visit() {
            // 外部类非静态成员变量不能被访问
            // age ++;
            System.out.println("静态内部类 visit outer static  variable:" + radius);
        }
    }

    /**
     * 成员内部类，定义在类内部，成员位置上的非静态类
     * 成员内部类可以访问外部类所有的变量和方法，包括静态和非静态，私有和公有。成员内部类依赖于外部类的实例，它的创建方式外部类实例.new 内部类()
     */
    class Inner {
        private int age = 13;

        public void print() {
            int age = 14;
            System.out.println("成员内部类 局部变量：" + age);
            System.out.println("成员内部类 内部类变量：" + this.age);
            System.out.println("成员内部类 外部类变量：" + Outer.this.age);
        }
    }


}
