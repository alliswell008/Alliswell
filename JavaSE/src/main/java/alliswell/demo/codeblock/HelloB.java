package alliswell.demo.codeblock;

class HelloA {

    // 构造方法
    public HelloA() {
        System.out.println("HelloA");
    }

    // 构造代码块
    {
        System.out.println("I'm A class");
    }

    // 静态代码块
    static {
        System.out.println("static A");
    }
}

public class HelloB extends HelloA {

    // 构造方法
    public HelloB() {
        System.out.println("HelloB");
    }

    // 构造方法
    public HelloB(String b) {
        System.out.println("HelloB："+ b);
    }

    // 构造代码块
    {
        System.out.println("I'm B class");
    }

    // 静态代码块
    static {
        System.out.println("static B");
    }

    public static void main(String[] args) {
        System.out.println("----------main start---------");
        new HelloB();
        new HelloB("b");
        System.out.println("----------main end----------");
    }
}
// 运行结果：
// static A
// static B
// ----------main start---------
// I'm A class
// HelloA
// I'm B class
// HelloB
// I'm A class
// HelloA
// I'm B class
// HelloB：b
// ----------main end----------

// 结果说明：
// 静态代码块类加载时执行且只执行一次
// 构造代码块会在构造方法之前执行，且在所有构造方法之前运行