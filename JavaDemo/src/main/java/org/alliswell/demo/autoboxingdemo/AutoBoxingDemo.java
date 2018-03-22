package org.alliswell.demo.autoboxingdemo;

/**
 * Created by Administrator on 2018/3/2.
 */
public class AutoBoxingDemo {

    public static void main(String[] args) {
        Integer a = new Integer(150);
        Integer b = 150;
        int c = 150;
        Integer d = 150;

        System.out.println(a == b); //false
        System.out.println(a == c); //true
        System.out.println(b == c); //true
        System.out.println(b == d); //true
    }
}
