package alliswell.demo.integer;

public class IntegerDemo {
    public static void main(String[] args) {
        testInteger();
    }
    public static void testInteger() {
        Integer in = 5;

        String s = "5";

        if (s.equals(in)) {
            System.out.println("String 5 == Integer 5");
        }

        if (in.equals(5)) {
            System.out.println("Integer 5 == Integer 5");
        }

        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;

        System.out.println(c == d);
        System.out.println(e == f);
    }
}