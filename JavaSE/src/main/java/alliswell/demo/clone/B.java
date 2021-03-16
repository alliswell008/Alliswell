package alliswell.demo.clone;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/1.
 */
public class B implements Cloneable, Serializable {
    String name;
    C c;

    public B(String name, C c) {
        this.name = name;
        this.c = c;
    }

    @Override
    protected Object clone() {
        B b = null;
        try {
            b = (B) super.clone();
            b.c = (C) c.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return b;
    }
}
