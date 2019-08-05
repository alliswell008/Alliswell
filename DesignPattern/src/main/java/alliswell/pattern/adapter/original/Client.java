package alliswell.pattern.adapter.original;

public class Client {

    public static void main(String[] args) {

        // 这里直接调用，使得AdapterClient类会依赖于Adaptee类
        Adaptee adaptee = new Adaptee();
        test(adaptee);
        Adaptee2 adaptee2 = new Adaptee2();
        test(adaptee2);
    }

    public static void test(Adaptee adaptee) {
        adaptee.specificRequest();
        adaptee.specificRequest2();
        adaptee.specificRequest3();
    }

    public static void test(Adaptee2 adaptee) {
        adaptee.specificRequest();
        adaptee.specificRequest2();
        adaptee.specificRequest3();
    }
}
