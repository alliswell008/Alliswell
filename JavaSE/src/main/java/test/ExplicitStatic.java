/**
 * @Title: ExplicitStatic
 * @Package test
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2016/12/9 16:53
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package test;

/**
 * @author alliswell008
 * @ClassName: ExplicitStatic
 * @Description: <p>静态变量、静态语句在类加载时初始化，非静态变量、非静态语句（匿名内部类）
 * 在对象创建时初始化,先执行静态变量、静态语句，再执行非静态变量、非静态语句
 * @date 2016/12/9 16:53
 */
public class ExplicitStatic {
    public static void main(String[] args) {
        System.out.println("Inside Main()");
        Cups.fun();
        Cups.c2.f(99);
    }
//    static Cups x = new Cups();
//    static Cups y = new Cups();
}

class Cups {
    Cup c1 = new Cup(1);
    static Cup c2 = new Cup(2);
    {
        c1 = new Cup(11);
        c2 = new Cup(22);
    }
    static {
        c2 = new Cup(222);
    }
    Cups() {
        System.out.println("Cups()");
    }
    static void fun() {
        System.out.println("static fun()");
    }
}

class Cup {
    Cup(int marker) {
        System.out.println("Cup(" + marker + ")");
    }
    void f(int marker) {
        System.out.println("f(" + marker + ")");
    }
}