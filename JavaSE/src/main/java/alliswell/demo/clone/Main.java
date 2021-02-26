package alliswell.demo.clone;

import java.util.Arrays;

/**
 * 举例来说更加清楚：对象A1中包含对B1的引用，B1中包含对C1的引用。
 * 浅拷贝A1得到A2，A2 中依然包含对B1的引用，B1中依然包含对C1的引用。
 * 深拷贝则是对浅拷贝的递归，深拷贝A1得到A2，A2中包含对B2（B1的copy）的引用，B2 中包含对C2（C1的copy）的引用。
 *
 * 实现对象的深度拷贝：1.实现Cloneable接口；2.对象实现序列化接口，序列化后再反序列化对象
 * @author alliswell
 * Created by Administrator on 2018/3/1.
 */
public class Main {
    public static void main(String[] args) {
        testA();
        testA1();
        testInt();
        testString();
        testSystemArraycopy();
        testArraysCopyOf();
        testArraysCopyOfRange();

    }

    static void testA() {
        C c = new C("cname");
        B b = new B("bname", c);
        A a = new A("aname", b);

        A a1 = (A) a.clone();
        a1.name = "a1name";
        a1.b.name = "b1name";
        a1.b.c.name = "c1name";

        System.out.println(a +"="+ a.name + "::" + a.b +"=" + a.b.name + "::" + a.b.c +"=" + a.b.c.name);
        System.out.println(a1 +"="+ a1.name + "::" + a1.b +"="+ a1.b.name + "::" + a1.b.c +"="+ a1.b.c.name);
    }

    static void testA1() {
        C c = new C("cname");
        B b = new B("bname", c);
        ADeepClone a = new ADeepClone("aname", b);

        ADeepClone a1 = (ADeepClone) a.clone();
        a1.name = "a1name";
        a1.b.name = "b1name";
        a1.b.c.name = "c1name";

        System.out.println(a +"="+ a.name + "::" + a.b +"="+ a.b.name + "::" + a.b.c +"="+ a.b.c.name);
        System.out.println(a1 +"="+ a1.name + "::" + a1.b +"="+ a1.b.name + "::" + a1.b.c +"="+ a1.b.c.name);
    }

    static void testInt() {
        int[] a1 = {1, 3};
        int[] a2 = a1.clone();

        a1[0] = 666;
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
    }

    static void testString() {
        String[] a1 = {"a1", "a2"};
        String[] a2 = a1.clone();

        a1[0] = "666";
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
    }

    static void testSystemArraycopy() {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = new int[10];

        // （原数组， 原数组的开始位置， 目标数组， 目标数组的开始位置， 拷贝个数）
        System.arraycopy(a1, 1, a2, 3, 3);
        System.out.println(Arrays.toString(a1)); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(a2)); // [0, 0, 0, 2, 3, 4, 0, 0, 0, 0]
    }

    static void testArraysCopyOf() {
        int[] a1 = {1, 2, 3, 4, 5};
        // （原数组，拷贝的个数）
        int[] a2 = Arrays.copyOf(a1, 3);

        System.out.println(Arrays.toString(a1)); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(a2)); // [1, 2, 3]
    }

    static void testArraysCopyOfRange() {
        int[] a1 = {1, 2, 3, 4, 5};
        // （原数组，开始位置，结束位置），原数组不足时补0
        int[] a2 = Arrays.copyOfRange(a1, 3, 7);

        System.out.println(Arrays.toString(a1)); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(a2)); // [4, 5, 0, 0]
    }
}

//alliswell.demo.clone.A@279f2327=aname::alliswell.demo.clone.B@2ff4acd0=b1name::alliswell.demo.clone.C@54bedef2=c1name
//alliswell.demo.clone.A@5caf905d=a1name::alliswell.demo.clone.B@2ff4acd0=b1name::alliswell.demo.clone.C@54bedef2=c1name
//alliswell.demo.clone.ADeepClone@27716f4=aname::alliswell.demo.clone.B@8efb846=bname::alliswell.demo.clone.C@2a84aee7=cname
//alliswell.demo.clone.ADeepClone@a09ee92=a1name::alliswell.demo.clone.B@30f39991=b1name::alliswell.demo.clone.C@452b3a41=c1name
//[666, 3]
//[1, 3]
//[666, a2]
//[a1, a2]
//[1, 2, 3, 4, 5]
//[0, 0, 0, 2, 3, 4, 0, 0, 0, 0]
//[1, 2, 3, 4, 5]
//[1, 2, 3]
//[1, 2, 3, 4, 5]
//[4, 5, 0, 0]