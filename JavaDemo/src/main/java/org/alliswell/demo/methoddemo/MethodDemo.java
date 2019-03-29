package org.alliswell.demo.methoddemo;

public class MethodDemo extends Method {
    public static void main(String[] args) {
        MethodDemo m = new MethodDemo();
        m.fun(1);
        m.fun();
    }

    @Override
    public void fun(int intA) {
        System.out.println("继承重载的A");
        super.fun(intA);
    }
}


interface IMethod {
    // 接口中的方法默认是public修饰的，不能被final修饰
    void fun();

    // 接口中的方法可以被static修饰，但不能被子类重写
    static void funA() {
        System.out.println("A");
    };
}

class Method implements IMethod {

    /**
     * final修饰方法，则子类继承后不能重写
     */
    @Override
    public final void fun() {
        System.out.println("A");
    }

    /**
     * 重载fun方法
     * @param intA
     */
    public void fun(int intA) {
        System.out.println("重载A");
    }
}