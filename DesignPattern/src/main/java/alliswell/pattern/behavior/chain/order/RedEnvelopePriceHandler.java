package alliswell.pattern.behavior.chain.order;


import java.math.BigDecimal;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/25
 */
public class RedEnvelopePriceHandler extends PriceHandler {
    @Override
    public void caculatePrice(Order order, Promotion promotion) {
        if (promotion instanceof RedEnvelope) {
            RedEnvelope redEnvelope = (RedEnvelope) promotion;
            BigDecimal price = BigDecimal.valueOf(order.getValue()).subtract(BigDecimal.valueOf(redEnvelope.getRedPrice()));
            System.out.println(String.format("订单%s/%s使用了红包%s的价格：%s", order.getOrderNum(),order.getValue(), redEnvelope.getRedPrice(), price.doubleValue()));
            order.setValue(price.doubleValue());
        } else {
            handler.caculatePrice(order, promotion);
        }
    }
}
