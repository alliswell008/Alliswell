package alliswell.pattern.behavior.command.barbecue;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/4
 */
public class BakeFood {
    BakeMenu food;
    Integer num;
    Boolean status;

    public BakeFood(BakeMenu bakeMenu, Integer num) {
        this.food = bakeMenu;
        this.num = num;
        this.status = false;
    }
}
