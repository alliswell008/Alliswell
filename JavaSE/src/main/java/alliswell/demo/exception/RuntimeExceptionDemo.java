package alliswell.demo.exception;

public class RuntimeExceptionDemo {
    public static void main(String[] args) {
        fun1();
        System.out.println("main");
    }

    public static void fun1() {
        //  运行异常可以不用捕获和向上抛出
        throw new Error("RuntimeException1");
    }

    public static void fun2() {
        try {
            //  非运行异常必须捕获或向上抛出
            throw new ClassNotFoundException("ClassNotFoundException2");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
