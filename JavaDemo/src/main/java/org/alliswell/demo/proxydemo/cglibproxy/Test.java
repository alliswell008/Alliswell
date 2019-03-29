package org.alliswell.demo.proxydemo.cglibproxy;

public class Test {
    void test() {
        System.out.println("cglib proxy test!");
    }

    public static void main(String[] args) {
        Test test = CglibProxyTest.newProxyInstance(Test.class);
        test.test();
    }
}
