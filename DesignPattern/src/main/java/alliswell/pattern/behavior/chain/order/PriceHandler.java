package alliswell.pattern.behavior.chain.order;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/25
 */
public abstract class PriceHandler {

    protected PriceHandler handler;

    public void setHandler(PriceHandler handler) {
        this.handler = handler;
    }

    public void caculatePrice(Order order, Promotion promotion){}

    public void caculatePrice(Order order){}
}
