package org.alliswell.pattern.adapter.original;

public class Client {

    public static void main(String[] args) {

        // 这里直接调用，使得AdapterClient类会依赖于Adaptee类
        Adaptee adaptee = new Adaptee();
        adaptee.specificRequest();
        adaptee.specificRequest2();
        adaptee.specificRequest3();
    }
}
