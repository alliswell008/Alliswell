/**
 * @Title: StaticInnerClass
 * @Package org.alliswell.demo.staticdemo
 * @Description: TODO(用一句话描述该文件做什么)
 * @author alliswell
 * @date 2017/2/24 14:25
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
 */
package org.alliswell.demo.staticdemo;

/**
 * @author alliswell
 * @Title: StaticInnerClass
 * @Package org.alliswell.demo.staticdemo
 * @Description: 静态内部类的执行
 * @date 2017/2/24 14:25
 */
public class StaticInnerClassDemo {

    // 构造方法 在new时执行
    public StaticInnerClassDemo() {
        System.out.println("Test class");
    }

    // 静态代码块 在类加载到jvm时执行
    static{
        System.out.println("static code block");
    }

    // 静态内部类 在调用时执行
    private static class StaticInnerClass {
        // 非静态的内部类不能定义静态代码块，也不能定义静态变量和方法
        static int x=0;
        static {
            x = 10;
            System.out.println("inner class static code block");
        }

        // 静态变量只初始化一次
        private static StaticInnerClassDemo staticInnerClassDemo = new StaticInnerClassDemo();

        public static void fun() {
            System.out.println(x);
            System.out.println(staticInnerClassDemo.hashCode());
        }
    }

    public static void main(String args[]){

        // 调用静态内部类时会先执行静态变量或代码块，静态方法不会执行
        StaticInnerClassDemo staticInnerClassDemo = StaticInnerClass.staticInnerClassDemo;
        System.out.println(staticInnerClassDemo.hashCode());
        StaticInnerClass.fun();
    }
}
