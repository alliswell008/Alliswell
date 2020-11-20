package alliswell.pattern.behavior.command.barbecue;

/**
 * 服务员
 *
 * @author chengxs
 * @date 2020/11/4
 */
public class Waiter {

    private BakeCommand bakeCommand;

    /**
     * 设置订单
     *
     * @param bakeMenu
     * @param num
     */
    public void setOrder(String orderNo, Barbecuer barbecuer, BakeMenu bakeMenu, int num) {
        getBakeCommand(orderNo, barbecuer, new BakeFood(bakeMenu, num));
        if (num > 0) {
            this.notifyBarbecuer();
        } else {
            this.notifyBarbecuerCancel();
        }
    }

    private void getBakeCommand(String orderNo, Barbecuer barbecuer, BakeFood bakeFood) {
        switch (bakeFood.food) {
            case Mutton:
                this.bakeCommand = BakeMuttonCommand.getInstance(orderNo, barbecuer, bakeFood);
                break;
            case Gluten:
                this.bakeCommand = BakeGlutenCommand.getInstance(orderNo, barbecuer, bakeFood);
                break;
            default:

        }
    }

    /**
     * 通知烧烤师傅
     */
    public void notifyBarbecuer() {
        bakeCommand.execute();
    }

    /**
     * 通知烧烤师傅
     */
    public void notifyBarbecuerCancel() {
        bakeCommand.executeCancel();
    }
}
