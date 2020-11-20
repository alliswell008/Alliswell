package alliswell.pattern.creational.builder;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/10
 */
public class Main {
    public static void main(String[] args) {
        PersonBuilder builder = new PersonBuilder();
        Person person = builder.name("lion")
                .address("america")
                .age(18)
                .sex(2)
                .height(180)
                .weight(150).getPerson();
        System.out.println(person.toString());
    }
}
