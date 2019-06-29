/**
 * @Title: FinalVariablesTest
 * @Package org.alliswell.demo.variablesdemo
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
package org.alliswell.demo.variablesdemo;

/**
 * @author alliswell
 * @Title: FinalVariablesTest
 * @Package org.alliswell.demo.variablesdemo
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017/3/27 15:34
 */
public class FinalVariablesTest {

    public static void main(String[] args) throws ClassNotFoundException {
//        System.out.println(VariablesClass.str0);
        new VariablesClass().f();
    }
}


class VariablesClass {
    // 非常量成员具有默认初始值
    static String str0;
    // 常量成员必须被初始化，再被调用时不会加载类
    static final String str1 = "abc";
    static String str2 = new String("abc");
    static final String str3 = new String("abc");
    static final FinalVariablesTest str4 = new FinalVariablesTest();

    static final String str10 = null;
    static String str20 = null;
    static final FinalVariablesTest str40 = null;

    static {
        System.out.println("static class VariablesClass");
    }

    void f() throws ClassNotFoundException {
        //仅装载类，不进行初始化，静态代码块未执行
        Class.forName("org.alliswell.demo.variablesdemo.ClassTest", false, this.getClass().getClassLoader());
        System.out.println("===");
        //装载类，并进行初始化，静态代码块执行
        Class.forName("org.alliswell.demo.variablesdemo.ClassTest", true, this.getClass().getClassLoader());
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