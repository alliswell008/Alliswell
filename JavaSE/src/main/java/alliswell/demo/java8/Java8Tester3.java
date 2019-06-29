package alliswell.demo.java8;

public class Java8Tester3 {
    public static void main(String args[]) {
        final int num = 1;
        // 在 Lambda 表达式当中不允许声明一个与局部变量同名的参数或者局部变量。
        Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
        s.convert(2);  // 输出结果为 3
    }

    // 函数式接口里只允许一个抽象方法，继承Object的方法除外
    @FunctionalInterface
    public interface Converter<T1, T2> {
        void convert(int i);

        // 允许继承Object的方法
        @Override
        boolean equals(Object o);

        // int fun(); // 不被允许

        static void fun() {

        }

        default void fun2() {

        }
    }
}