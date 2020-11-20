package alliswell.pattern.creational.builder.gameperson;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/16
 */
public class Main {

    public static void main(String[] args) {
        PersonThinBuilder ptb = new PersonThinBuilder("瘦子", "瘦");
        PersonDirector pdThin = new PersonDirector(ptb);
        pdThin.createPerson();

        PersonFatBuilder pfb = new PersonFatBuilder("胖子", "胖");
        PersonDirector pdFat = new PersonDirector(pfb);
        pdFat.createPerson();
    }
}
