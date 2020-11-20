package alliswell.pattern.creational.builder;

/**
 * 构造器
 *
 * @author chengxs
 * @date 2020/11/10
 */
public class PersonBuilder {
    private Person person;

    public PersonBuilder() {
        this.person = new Person();
    }

    public Person getPerson() {
        return person;
    }

    public PersonBuilder name(String name) {
        this.person.setName(name);
        return this;
    }

    public PersonBuilder address(String address) {
        this.person.setAddress(address);
        return this;
    }

    public PersonBuilder age(int age) {
        this.person.setAge(age);
        return this;
    }

    public PersonBuilder sex(int sex) {
        this.person.setSex(sex);
        return this;
    }

    public PersonBuilder height(int height) {
        this.person.setHeight(height);
        return this;
    }

    public PersonBuilder weight(int weight) {
        this.person.setWeight(weight);
        return this;
    }
}
