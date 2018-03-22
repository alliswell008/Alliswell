package org.alliswell.demo.clonedemo;

/**
 * Created by Administrator on 2018/3/1.
 */
public class ADeepClone implements Cloneable {
    String name;
    B b;

    public ADeepClone(String name, B b) {
        this.name = name;
        this.b = b;
    }

    @Override
    public Object clone() {
        ADeepClone deepClone = null;
        try {
            deepClone = (ADeepClone) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        deepClone.b = (B) b.clone();

        return deepClone;
    }
}
