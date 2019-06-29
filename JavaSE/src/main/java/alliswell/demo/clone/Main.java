package alliswell.demo.clone;

/**
 * 举例来说更加清楚：对象A1中包含对B1的引用，B1中包含对C1的引用。
 * 浅拷贝A1得到A2，A2 中依然包含对B1的引用，B1中依然包含对C1的引用。
 * 深拷贝则是对浅拷贝的递归，深拷贝A1得到A2，A2中包含对B2（B1的copy）的引用，B2 中包含对C2（C1的copy）的引用。
 * @author alliswell
 * Created by Administrator on 2018/3/1.
 */
public class Main {
    public static void main(String[] args) {
        testA();
        testA1();

        bk:
        for (int i = 0; i < 10; i++) {
            System.out.println("i=" + i);
            for (int j = 0; j < 10; j++) {
                System.out.println("j=" + j);
                if (j == 2) {
                    System.out.println("bk");
                    break bk;
                }
            }
        }
        System.out.println("bk over");
    }

    static void testA() {
        C c = new C("cname");
        B b = new B("bname", c);
        A a = new A("aname", b);

        A a1 = (A) a.clone();
        a1.name = "a1name";
        a1.b.name = "b1name";
        a1.b.c.name = "c1name";

        System.out.println(a +"="+ a.name + "-" + a.b +"=" + a.b.name + "-" + a.b.c +"=" + a.b.c.name);
        System.out.println(a1 +"="+ a1.name + "-" + a1.b +"="+ a1.b.name + "-" + a1.b.c +"="+ a1.b.c.name);
    }

    static void testA1() {
        C c = new C("cname");
        B b = new B("bname", c);
        ADeepClone a = new ADeepClone("aname", b);

        ADeepClone a1 = (ADeepClone) a.clone();
        a1.name = "a1name";
        a1.b.name = "b1name";
        a1.b.c.name = "c1name";

        System.out.println(a +"="+ a.name + "-" + a.b +"="+ a.b.name + "-" + a.b.c +"="+ a.b.c.name);
        System.out.println(a1 +"="+ a1.name + "-" + a1.b +"="+ a1.b.name + "-" + a1.b.c +"="+ a1.b.c.name);
    }
}

//testA()输出：浅拷贝
//A@523e59ca=aname-B@7b7906f4=b1name-C@46b7bc80=c1name
//A@48b89bc5=a1name-B@7b7906f4=b1name-C@46b7bc80=c1name
//testA1()输出：深拷贝
//ADeepClone@7b3a4cdc=aname-B@308c3eb8=bname-C@4769baee=cname
//ADeepClone@6e6f83e2=a1name-B@5b3ba312=b1name-C@284f2189=c1name