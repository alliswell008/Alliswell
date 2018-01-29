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
 * @Description: private变量、方法、域不能被外部类调用，
 * 只拥有私有构造方法的类不能被继承
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
     * 错误提示：There is no default constructor available in 'org.alliswell.demo.variablesdemo.MainPrivate'
     */
//    private MainPrivate() {
//
//    }


}
