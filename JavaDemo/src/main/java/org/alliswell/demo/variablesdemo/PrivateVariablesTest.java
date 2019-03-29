/**
 * @Title: TestPrivate
 * @Package test
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2016/12/9 17:54
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package org.alliswell.demo.variablesdemo;

/**
 * @author alliswell008
 * @ClassName: TestPrivate
 * @Description: 1.private变量、方法、域不能被外部类调用，
 *               2.只拥有私有构造方法的类不能被继承
 *               3.被允许继承的类必须要有public修饰的空构造方法
 * @date 2016/12/9 17:54
 */
public class PrivateVariablesTest {
    public static void main(String[] args) {
        SubPrivate subPrivate = new SubPrivate();
        // private变量不能被外部访问
//        System.out.println(subPrivate.priName);
        System.out.println(subPrivate.freName);
        System.out.println(subPrivate.proName);
        System.out.println(subPrivate.pubName);

        MainPrivate mainPrivate = new MainPrivate();
        System.out.println(mainPrivate.freName);
        System.out.println(mainPrivate.proName);
        System.out.println(mainPrivate.pubName);

        subPrivate.publicFun();
        mainPrivate.publicFun();
//        mainPrivate.fun();
    }

}

class SubPrivate extends MainPrivate {

}

class MainPrivate {
    private String priName = "MainPrivate";
    String freName = "MainPrivate";
    protected String proName = "MainPrivate";
    public String pubName = "MainPrivate";

    /**
     * 私有的空构造方法使MainPrivate类不能被子类SubPrivate继承
     * 错误提示：There is no default constructor available in 'org.alliswell.demo.variablesdemo.PrivateVariablesTest.MainPrivate'
     */
    private MainPrivate(int a) {

    }

    MainPrivate() {

    }
    private void fun() {
        System.out.println("private method");
    }

    public void publicFun() {
        System.out.println("public method");
    }
}
