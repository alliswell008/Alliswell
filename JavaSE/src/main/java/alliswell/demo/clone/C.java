package alliswell.demo.clone;

/**
 * Created by Administrator on 2018/3/1.
 */
public class C implements Cloneable {
    String name;


    public C(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
