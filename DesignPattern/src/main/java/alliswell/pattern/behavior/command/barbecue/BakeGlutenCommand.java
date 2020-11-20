package alliswell.pattern.behavior.command.barbecue;

/**
 * 烤面筋串
 *
 * @author chengxs
 * @date 2020/11/4
 */
public class BakeGlutenCommand implements BakeCommand {

    private Barbecuer barbecuer;
    private BakeFood bakeFood;
    private String orderNo;

    private static final BakeGlutenCommand instance = null;

    public static BakeCommand getInstance(String orderNo, Barbecuer barbecuer, BakeFood bakeFood) {
        if (instance != null && instance.orderNo.equals(orderNo)) {
            return instance;
        } else {
            return new BakeGlutenCommand(orderNo, barbecuer, bakeFood);
        }
    }

    public BakeGlutenCommand(String orderNo, Barbecuer barbecuer, BakeFood bakeFood) {
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
            barbecuer.bakeCancel(orderNo, BakeMenu.Gluten, bakeFood.num);
        }
    }
}
