package test;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    static boolean foo(char c) {
        System.out.print(c);
        return true;
    }

    public static void main(String[] args) {
        int i = 0;
        for (foo('A'); foo('B') && (i < 2); foo('c')) {
            i++;
            foo('D');
        }

        A a = new A();
        a.setA1("a1");
        a.setA2("a2");

        change(a);
        System.out.println(a);
//        System.out.println(aa);

        A aa = null;
        boolean f = aa != null
                && ((aa.getA1() != null && aa.getA1().contains("A"))
                || (aa.getA2() != null && aa.getA2().contains("a")));
        System.out.println(f);
        Integer in = null;
        f = Integer.valueOf(1).equals(in);
        System.out.println(f);

        // System.out.println()不能传入null 因为会使用toString()方法
//        Long l = null;
//        test(l);

        // Integer 不可以赋值给 Long
//        Integer integer = 1;
//        Long aLong = integer;

        // String.valueOf()不可以传null
//        System.out.println(String.valueOf(null));

        // 逻辑或 短路
        if (aa == null || aa.getA1() == null) {
            System.out.println("||短路");
        }

        // List可以添加null元素
        List<A> list = new ArrayList<>();
        list.add(null);
        list.add(new A());
        System.out.println(list.size());
        System.out.println(list);
        A ob = list.get(1);
        // 操作List中的元素
        ob.setA1("1111");
        System.out.println(list);
        list.set(0, new A());
        System.out.println(list);

        // 引用类型尽量使用equals方法判断
        System.out.println(Boolean.TRUE.equals(null));
    }

    // 单jvm中会回写参数，多jvm时通过反序列化不会回写
    public static A change(A a) {
        a.setA1("AAAAA");
        return a;
    }

    public static void test(long l) {
        System.out.println(l);
    }
}

@Data
class A {
    private String a1;
    private String a2;
}