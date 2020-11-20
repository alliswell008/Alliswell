package alliswell.pattern.creational.builder.gameperson;

import java.awt.*;

/**
 * 抽象建造者
 *
 * @author chengxs
 * @date 2020/11/16
 */
public abstract class PersonBuilder {
    protected String name;
    protected String value;

    public PersonBuilder(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public abstract void buildHead();
    public abstract void buildBody();
    public abstract void buildArmLeft();
    public abstract void buildArmRight();
    public abstract void buildLegLeft();
    public abstract void buildLegRight();
}
