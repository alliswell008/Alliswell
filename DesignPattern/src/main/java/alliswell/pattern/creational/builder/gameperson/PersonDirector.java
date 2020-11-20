package alliswell.pattern.creational.builder.gameperson;

/**
 * 指挥者，控制建造过程，用来隔离用户和建造过程
 *
 * @author chengxs
 * @date 2020/11/16
 */
public class PersonDirector {
    private PersonBuilder pb;

    public PersonDirector(PersonBuilder pb) {
        this.pb = pb;
    }

    /**
     * 具体建造过程，使用户不需要关心具体过程，这样就隔离了用户和建造过程
     */
    public void createPerson() {
        pb.buildHead();
        pb.buildBody();
        pb.buildArmLeft();
        pb.buildArmRight();
        pb.buildLegLeft();
        pb.buildLegRight();
        System.out.println("构造了一个" + pb.name);
    }
}
