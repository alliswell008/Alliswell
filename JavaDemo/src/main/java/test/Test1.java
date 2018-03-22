package test;

/**
 * 值传递
 */
public class Test1 {
    public static void changeStr(String str) {
        str = "welcome";
        str = String.valueOf("welcome");
    }

    public static void changeA(A a) {
        a = new Test1().new A("welcome");
    }

    public static void main(String[] args) {
        String str = "1234";
        changeStr(str);
        System.out.println(str);


        A a = new Test1().new A("4321");
        changeA(a);
        System.out.println(a.name);

//        new Test1().sqrt(2);

        String ab = "0";
        switch (ab) {
            case "0":
                break;
        }
    }

    public class A {
        String name;

        public A(String name) {
            this.name = name;
        }
    }

}

//interface TestMethod {
//    static void method() {
//        /**
//         * 1、定义一个静态的带有方法体的方法
//         * 2、接口不能创建对象，调用静态方法不需要对象
//         * 3、接口名调用
//         */
//        System.out.println("接口中静态方法");
//
//        String a = "0";
//        switch (a) {
//            case "0":
//                break;
//        }
//
//    }
//
//    default double jkhj(int a) {
//        return Math.sqrt(a);
//    }
//}