/**
 * @Title: FinalVariablesTest
 * @Package org.alliswell.demo.variables
 * @Description: TODO(用一句话描述该文件做什么)
 * @author alliswell
 * @date 2017/3/27 15:34
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
 */
package alliswell.demo.variables;

/**
 * @author alliswell
 * @Title: FinalVariablesTest
 * @Package org.alliswell.demo.variables
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017/3/27 15:34
 */
public class FinalVariablesTest {

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(VariablesClass.str5);
        System.out.println("==================");
        new VariablesClass().f();
    }
}


class VariablesClass {
    // 这里static是为了不new对象来调用成员变量，因为new对象时类会先运行：1.装载 2.连接 3.初始化
    // 基本数据类型，这里以int为例
    // 成员变量（不是常量）具有默认初始值0，不需要显式初始化
    static int i1;
    // 成员变量显式初始化
    static int i2 = 0;
    // 编译错误，常量成员必须被显式初始化
//    static final int i3;
    // 基本数据类型的常量成员，在被调用时不会加载运行类，表现为该类中的静态代码块不会执行
    static final int i4 = 0;

    // 引用类型
    // 成员变量（不是常量）具有默认初始值null，不需要显式初始化
    static String str0;
    // 成员变量显式初始化
    static String str1 = "abc";
    static String str2 = "abc".intern();
    static String str3 = new String("abc");
    static String str20 = null;
    // 编译错误，常量成员必须被显式初始化
    //    static final String str4;
    // String作为引用类型的特列，如果被初始化为"abc"时，那么在被调用时不会加载运行类，表现为该类中的静态代码块不会执行
    static final String str5 = "abc";
    // 其他情况的引用类型初始化时，都会加载运行类，表现为该类中的静态代码块执行
    static final String str6 = "abc".intern();
    static final String str7 = new String("abc");
    static final String str10 = null;

    static FinalVariablesTest test1;
    static FinalVariablesTest test2 = new FinalVariablesTest();
    static FinalVariablesTest test3 = null;
//    static final FinalVariablesTest test4;
    static final FinalVariablesTest test5 = new FinalVariablesTest();
    static final FinalVariablesTest test6 = null;


    static {
        System.out.println("static class VariablesClass");
    }

    void f() throws ClassNotFoundException {
        //仅装载类，不进行初始化，静态代码块未执行
        Class.forName("alliswell.demo.variables.ClassTest", false, this.getClass().getClassLoader());
        System.out.println("===");
        //装载类，并进行初始化，静态代码块执行
        Class.forName("alliswell.demo.variables.ClassTest", true, this.getClass().getClassLoader());
    }
}

/**
 * 一个类的运行分为以下步骤： 1.装载 2.连接 3.初始化
 */
class ClassTest {
    static {
        System.out.println("static class ClassTest");
    }
}