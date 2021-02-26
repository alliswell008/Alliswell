package alliswell.demo.integer;

import sun.misc.VM;

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
            System.out.println("Integer 5 == int 5");
        }

        if (new Integer(5) == 5) {
            System.out.println("new Integer 5 == int 5");
        }

        System.out.println(in == 5);
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;

        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c.equals(d) );
        System.out.println(e.equals(f));

        Long ll = 1234567891011L;
        System.out.println(ll.intValue());
        System.out.println(ll.longValue());

        // -XX:AutoBoxCacheMax=20 或 -XX:AutoBoxCacheMax=200
        String var1 = VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
        System.out.println(var1);

        Integer aa = 199;
        Integer bb = Integer.valueOf(199);
        System.out.println(aa == bb);
    }
}