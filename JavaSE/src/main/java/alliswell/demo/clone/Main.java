package alliswell.demo.clone;

/**
 * 举例来说更加清楚：对象A1中包含对B1的引用，B1中包含对C1的引用。
 * 浅拷贝A1得到A2，A2 中依然包含对B1的引用，B1中依然包含对C1的引用。
 * 深拷贝则是对浅拷贝的递归，深拷贝A1得到A2，A2中包含对B2（B1的copy）的引用，B2 中包含对C2（C1的copy）的引用。
 * <p>
 * 实现对象的深度拷贝：1.实现Cloneable接口；2.对象实现序列化接口，序列化后再反序列化对象
 *
 * @author alliswell
 * Created by Administrator on 2018/3/1.
 */
public class Main {
    public static void main(String[] args) {
        testA();
        testA1();
        testDog();
    }

    static void testA() {
        C c = new C("cname");
        B b = new B("bname", c);
        A a = new A("aname", b);

        A a1 = (A) a.clone();
        a1.name = "a1name";
        a1.b.name = "b1name";
        a1.b.c.name = "c1name";

        System.out.println(a + "=" + a.name + "::" + a.b + "=" + a.b.name + "::" + a.b.c + "=" + a.b.c.name);
        System.out.println(a1 + "=" + a1.name + "::" + a1.b + "=" + a1.b.name + "::" + a1.b.c + "=" + a1.b.c.name);
    }

    static void testA1() {
        C c = new C("cname");
        B b = new B("bname", c);
        ADeepClone a = new ADeepClone("aname", b);

        ADeepClone a1 = (ADeepClone) a.clone();
        a1.name = "a1name";
        a1.b.name = "b1name";
        a1.b.c.name = "c1name";

        System.out.println(a + "=" + a.name + "::" + a.b + "=" + a.b.name + "::" + a.b.c + "=" + a.b.c.name);
        System.out.println(a1 + "=" + a1.name + "::" + a1.b + "=" + a1.b.name + "::" + a1.b.c + "=" + a1.b.c.name);
    }


    static void testDog() {
        Dog dog = new Dog(new A("a", new B("b", new C("c"))));
        Dog dog1 = dog.myClone();
        Dog dog2 = dog;
        dog.a.b.c.name = "c clone";

        System.out.println(dog + "=" + dog.a.b.c.name);
        System.out.println(dog1 + "=" + dog1.a.b.c.name);
        System.out.println(dog2 + "=" + dog2.a.b.c.name);
    }



}

//alliswell.demo.clone.A@279f2327=aname::alliswell.demo.clone.B@2ff4acd0=b1name::alliswell.demo.clone.C@54bedef2=c1name
//alliswell.demo.clone.A@5caf905d=a1name::alliswell.demo.clone.B@2ff4acd0=b1name::alliswell.demo.clone.C@54bedef2=c1name
//alliswell.demo.clone.ADeepClone@27716f4=aname::alliswell.demo.clone.B@8efb846=bname::alliswell.demo.clone.C@2a84aee7=cname
//alliswell.demo.clone.ADeepClone@a09ee92=a1name::alliswell.demo.clone.B@30f39991=b1name::alliswell.demo.clone.C@452b3a41=c1name
