package alliswell.pattern.creational.builder.gameperson;

import java.awt.*;

/**
 * 瘦子建造者，建造具体的特征表示
 *
 * @author chengxs
 * @date 2020/11/16
 */
public class PersonThinBuilder extends PersonBuilder {
    public PersonThinBuilder(String name, String value) {
        super(name, value);
    }

    @Override
    public void buildHead() {
        System.out.println("构建头"+":"+value);
    }

    @Override
    public void buildBody() {
        System.out.println("构建身体"+":"+value);
    }

    @Override
    public void buildArmLeft() {
        System.out.println("构建左手"+":"+value);
    }

    @Override
    public void buildArmRight() {
        System.out.println("构建右手"+":"+value);
    }

    @Override
    public void buildLegLeft() {
        System.out.println("构建左腿"+":"+value);
    }

    @Override
    public void buildLegRight() {
        System.out.println("构建右腿"+":"+value);
    }
}
