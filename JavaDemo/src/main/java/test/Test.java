/**
 * @Title: Test
 * @Package test
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2016/12/12 17:07
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package test;

import sun.misc.VM;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author alliswell008
 * @ClassName: Test
 * @Description:
 * @date 2016/12/12 17:07
 */
public class Test {

    // 构造方法 在new时执行
    public Test() {
        System.out.println("Test class");
    }

    // 静态代码块 在类加载到jvm时执行
    static{
        System.out.println("static code block");
    }

    // 静态内部类 在调用时执行
    private static class StaticInnerClass {
        static {
            System.out.println("inner class static code block");
        }

        // 非常量成员具有默认初始值
        private static String str0;
        // 常量成员必须被初始化
        private static final String str1 = "abc";
        private static String str2 = new String("abc");
        private static final String str3 = new String("abc");
        private final static Test test = new Test();

        static void staticFun() {
            System.out.println("staticFun");
        }
    }

    public static void main(String args[]){
        //getResult();

        // 调用静态内部类
//        String test = StaticInnerClass.str1;
//        String test = StaticInnerClass.str2;
        String test = StaticInnerClass.str3;
//        StaticInnerClass.staticFun();

        Integer in = 5;

        String s = "5";

        if (s.equals(in)) {
            System.out.println("String 5 == Integer 5");
        }

        if (in.equals(5)) {
            System.out.println("Integer 5 == Integer 5");
        }

        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;

        System.out.println(c == d);
        System.out.println(e == f);

        String host = "172.16.145.159";

        String ff = !host.equals("127.0.0.1") && !host.startsWith("localhost") && !host.equals("0.0.0.0") && !host.startsWith("169.254") && !host.startsWith("::1") && !host.startsWith("0:0:0:0:0:0:0:1")?host:"";
        System.out.println(ff);

        String var1 = VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
        Integer a = new Integer(2);
        String var2 = VM.getSavedProperty("java.lang.Integer.IntegerCache.high");

        System.out.println(var1);
        System.out.println(var2);
    }

    /**
     * （x++)/3是先执行x/3的操作，就相当于先执行2/3，/操作取结果的整数部分，
     *  所以是0，这些操作完成之后才会将+1的值赋值给x。你如果将x++换成++x,
     *  就是先将+1的值赋给x（此时x）,再进行3/3操作，此时在运行，结果为1
     */
    static void getResult() {
        int x=2,t1=0,t2;
        t1=(x++)/3;

        x=2;
        t2=(++x)/3;

        System.out.println("t1="+t1+",t2="+t2);
    }

    void test() {
        System.out.println("test");
    }

}