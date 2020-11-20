package alliswell.pattern.behavior.command.barbecue;

/**
 * 烤羊肉串
 *
 * @author chengxs
 * @date 2020/11/4
 */
public class BakeMuttonCommand implements BakeCommand {

    private Barbecuer barbecuer;
    private String orderNo;
    private BakeFood bakeFood;

    private static BakeMuttonCommand instance = null;

    public static BakeCommand getInstance(String orderNo, Barbecuer barbecuer, BakeFood bakeFood) {
        if (instance != null && instance.orderNo.equals(orderNo)) {
            return instance;
        } else {
            instance = new BakeMuttonCommand(orderNo, barbecuer, bakeFood);
            return instance;
        }
    }

    public BakeMuttonCommand(String orderNo, Barbecuer barbecuer, BakeFood bakeFood) {
        this.barbecuer = barbecuer;
        this.bakeFood = bakeFood;
        this.orderNo = orderNo;
    }

    @Override
    public void execute() {
        barbecuer.bake(orderNo, bakeFood);
    }

    @Override
    public void executeCancel() {
        if (bakeFood.status) {
            System.out.println("已经烤了，不能取消");
        } else {
            barbecuer.bakeCancel(orderNo, BakeMenu.Mutton, bakeFood.num);
        }
    }
}
