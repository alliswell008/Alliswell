package alliswell.demo.variables;

import java.io.Serializable;

/**
 * 变量：
 *    定义：计算机语言中能储存计算结果或能表示值的抽象概念。变量可以通过变量名访问。
 *    使用范围：类体中、接口体中、方法体中、方法参数中和代码块中
 *    修饰符：修饰符有一定的使用范围，另外可以组合使用
 *          访问修饰符：public(所有类可访问)、protected（本类和本类的子类可访问）、private（仅本类可访问）和无访问修饰符（friendly，同一包中的类可访问）
 *          最终修饰符：final 指定此变量的值不能变。
 *          静态修饰符：static 指定变量被所有对象共享，即所有实例都可以使用该变量。变量属于这个类。
 *          序列化修饰符：transient 对象序列化时忽略被此修饰的成员变量
 *          可见性修饰符：volatile 防止指令重排和保证可见性即保证修改的值会立即被更新到主存，当有其他线程需要读取时，它会去内存中读取新值。
 *          数据类型修饰符：8中基本数据类型和引用类型
 *     分类：
 *          按照使用范围：成员变量(或叫全局变量，类体中)、局部变量（方法体中、代码块中）和参数变量（方法参数中）
 *          按照修饰符：公共访问变量、保护访问变量、私有访问变量、包访问变量、常量、静态变量、基本数据类型变量和引用类型变量
 */
interface Var extends Serializable{
    /** 接口体中的变量默认是public、static和final修饰的即所有类可访问的静态常量，它不可以被transient和volatile修饰 */
    int intA = 1;
}

/**
 * 类体中的变量，由下面的代码可知 成员变量 = 访问修饰符 + [final、static、transient、volatile] + 数据类型修饰符 + 变量名
 */
class Variables implements Var, Serializable {
    /** 非常量成员变量具有默认初始值；基本数据类型有默认的值，而引用类型默认为null */
    public int intA;
    public String strA;

    /** 常量成员变量必须初始化值赋值 */
    public final int intB = 0;
    public final String strB = null;

    /** 静态成员变量，只能修饰成员变量，不能修饰局部变量和参数变量。使成员变量变成类的变量，使用该变量时不需要实例化对象，直接使用类名.变量名。*/
    public static int intC;
    public static String strC;

    /** transient修饰的变量，只能修饰成员变量，用于序列化时忽略被修饰的类成员变量 */
    public transient int intD;
    public transient String strD;

    /** volatile修饰的变量，只能修饰全局变量也即成员变量，多线程中用于确保线程安全（具有可见性、一定的有序性，但不具有原子性；所以在非原子操作时volatile变量不能确保线程安全）*/
    public volatile int intE;
    public volatile String strE;

    /** volatile和static修饰的变量，修饰顺序无关 */
    public volatile static int intF;
    public static volatile String strF;

    /** volatile和static修饰的变量，修饰顺序无关 */
    public volatile transient static int intG;
    public static volatile transient String strG;

    /**
     * 静态成员变量与非静态成员变量的区别：（常量为什么要用static修饰？）
     *
     * 静态成员变量是类的变量，在类加载时就会分配内存来储存而且只此一次，之后就能被该类的所有实例对象共用。
     * 非静态成员变量是类的实例对象的变量，每次创建对象时都需要分配一次内存来存储，则每个实例对象都有各自的成员变量。
     */
    /** static和final修饰的变量，修饰顺序无关 */
    public final static int intH = 0;
    public static final String strH = null;

    void fun(int intA/*参数变量*/) {
        // 方法体中的局部变量,所有局部变量在使用时需要被初始化
        int a = 1;
        intA = intA + a;
        System.out.println("方法体中的局部变量:"+ intA);
    }

    void fun(/*被final修饰的参数变量*/ final StringBuffer sb) {
        //引用类型的参数变量被final修饰时，不能被修改是变量的引用，但可以修改变量的值
        //另外基本类型的变量被final修饰时，不能改变的就是变量的值
        //sb = new StringBuffer("abc"); // new时会产生新的引用
        sb.append("abc");
        System.out.println(sb);
    }

    {
        fun(1);
        fun(new StringBuffer("str-"));
        // 代码块中的局部变量
        int intA = 0;
        System.out.println("代码块中的局部变量:"+ intA);
    }
}


public class VariablesDemo extends Variables {

    public static void main(String[] args) {
        Var var = new Variables();
        // 这里涉及到静态变量是否被继承，静态变量是否能实现多态
        // 静态变量能被继承，但不能实现多态（父类引用指向子类对象时会产生多态，但父类引用调用静态变量时只会调用父类的静态变量）
        System.out.println(var.intA);// 期望是0，实际是1
    }
}
