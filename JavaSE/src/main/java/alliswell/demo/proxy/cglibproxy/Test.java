package alliswell.demo.proxy.cglibproxy;

import alliswell.demo.proxy.A;

public class Test {

    public static void main(String[] args) {
        A test = CglibProxy.newProxyInstance(A.class);
        test.del();
    }
}
