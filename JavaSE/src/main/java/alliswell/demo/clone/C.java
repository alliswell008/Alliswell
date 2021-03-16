package alliswell.demo.clone;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/1.
 */
public class C implements Cloneable, Serializable {
    String name;


    public C(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
