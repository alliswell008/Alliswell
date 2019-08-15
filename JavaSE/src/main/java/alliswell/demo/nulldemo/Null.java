package alliswell.demo.nulldemo;

public class Null {
    public static void hello() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        // null值可以强制转换成任何类型
        ((Null)null).hello();
    }
}

