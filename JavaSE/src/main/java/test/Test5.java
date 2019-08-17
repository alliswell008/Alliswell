package test;

import java.util.Vector;

public class Test5 {

    public static void main(String[] args) {
        Vector v = new Vector(10);

        Test5Object o = new Test5Object(0);
        for (int i = 0; i < 100; i ++) {
            o.setValue(i);
            v.add(o);
            System.out.println(o);
//            o = null;
            System.out.println(o);
        }

        System.out.println(v.get(99));
    }
}


class Test5Object {
    public void setValue(int value) {
        this.value = value;
    }

    int value;

    public Test5Object(int value) {
        this.value = value;
    }
}