package alliswell.demo.classdemo;

/**
 * @Title: OuterClass
 * @Package alliswell.demo.classdemo
 * @Description: TODO(用一句话来说明)
 * @Author Administrator
 * @CreateDate 2019/5/20 17:55
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
public class OuterClass {

    public static void main(String[] args) {
        new OuterClass().testInnerClass();
        InnerStaticClass.InnerStaticClassStaticMethod();
        System.out.println(InnerStaticClass.i);
    }

    public void testInnerClass() {
        InnerClass innerClass = new InnerClass();
        innerClass.innerClassMethod();
    }

    void outerClassMethod() {
        System.out.println("outerClassMethod");
    }

    static void outerClassStaticMethod() {
        System.out.println("outerClassStaticMethod");
    }

    // 非静态内部类中的方法能调用外部类中的所有方法
    class InnerClass {

        // 内部类不能定义静态方法和静态变量
//        static int i;
//        static void innerClassStaticMethod() {
//        }

        void innerClassMethod() {
            outerClassMethod();
            outerClassStaticMethod();
        }
    }

    // 静态内部类中的方法不能调用外部类中的非静态方法
    static class InnerStaticClass {

        static int i=100;
        static void InnerStaticClassStaticMethod() {
//            outerClassMethod();
            outerClassStaticMethod();
        }

        void InnerStaticClassMethod() {
//            outerClassMethod();
            outerClassStaticMethod();
        }
    }

}
