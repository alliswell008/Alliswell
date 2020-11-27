package alliswell.pattern.behavior.chain.order;

import java.math.BigDecimal;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/25
 */
public class CouponPriceHandler2 extends PriceHandler {
    @Override
    public void caculatePrice(Order order) {
        for (Promotion promotion : order.getPromotionList()) {
            if (promotion.isStatus()) {
                continue;
            }
            if (promotion instanceof Coupon) {
                Coupon coupon = (Coupon) promotion;
                if (order.getValue() >= coupon.getOverPrice()) {
                    BigDecimal price = BigDecimal.valueOf(order.getValue()).subtract(BigDecimal.valueOf(coupon.getMinusPrice()));
                    System.out.println(String.format("订单%s/%s使用了优惠券满%s减%s的价格：%s", order.getOrderNum(),order.getValue(), coupon.getOverPrice(), coupon.getMinusPrice(), price.doubleValue()));
                    order.setValue(price.doubleValue());
                } else {
                    System.out.println(String.format("订单%s/%s不满足优惠券满%s减%s的价格：%s", order.getOrderNum(), order.getValue(),coupon.getOverPrice(), coupon.getMinusPrice(), order.getValue()));
                }
                coupon.setStatus(true);
            } else {
            }
        }
        if (handler != null) {
            handler.caculatePrice(order);
        }
    }
}
