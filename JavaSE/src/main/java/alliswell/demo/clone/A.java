package alliswell.demo.clone;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/1.
 */
public class A implements Cloneable, Serializable {
    String name;
    B b;

    public A(String name, B b) {
        this.name = name;
        this.b = b;
    }

    @Override
    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return o;
    }
}
