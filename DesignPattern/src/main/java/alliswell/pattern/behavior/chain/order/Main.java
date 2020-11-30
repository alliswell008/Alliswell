package alliswell.pattern.behavior.chain.order;

import cn.hutool.json.JSONUtil;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/25
 */
public class Main {
    public static void main(String[] args) {
        main1();
        System.out.println("===========");
        main2();

    }

    public static void main1() {
        PriceHandler couponHandler = new CouponPriceHandler();
        PriceHandler integralHandler = new IntegralPriceHandler();
        PriceHandler redEnvelopeHandler = new RedEnvelopePriceHandler();
        couponHandler.setHandler(integralHandler);
        integralHandler.setHandler(redEnvelopeHandler);

        Order order = new Order("0001", 20, "元");
        // 使用顺序：券、积分、红包
        order.addPromotion(new Coupon(10, 2));
        order.addPromotion(new Integral(4));
        order.addPromotion(new RedEnvelope(8));
        order.addPromotion(new Coupon(2, 1));
        System.out.println(JSONUtil.toJsonStr(order));
        for (Promotion promotion : order.getPromotionList()) {
            couponHandler.caculatePrice(order, promotion);
        }

        System.out.println("----------");

        order = new Order("0001", 20, "元");
        // 使用顺序：积分、红包、券
        order.addPromotion(new Integral(4));
        order.addPromotion(new RedEnvelope(8));
        order.addPromotion(new Coupon(10, 2));
        order.addPromotion(new Coupon(2, 1));
        System.out.println(JSONUtil.toJsonStr(order));
        for (Promotion promotion : order.getPromotionList()) {
            couponHandler.caculatePrice(order, promotion);
        }
    }

    public static void main2() {

        PriceHandler couponHandler = new CouponPriceHandler2();
        PriceHandler integralHandler = new IntegralPriceHandler2();
        PriceHandler redEnvelopeHandler = new RedEnvelopePriceHandler2();
        couponHandler.setHandler(integralHandler);
        integralHandler.setHandler(redEnvelopeHandler);

        Order order = new Order("0001", 20, "元");
        order.addPromotion(new Coupon(10, 2));
        order.addPromotion(new Integral(4));
        order.addPromotion(new RedEnvelope(8));
        order.addPromotion(new Coupon(2, 1));
        System.out.println(JSONUtil.toJsonStr(order));
        couponHandler.caculatePrice(order);

        System.out.println("----------");

        integralHandler.setHandler(redEnvelopeHandler);
        redEnvelopeHandler.setHandler(couponHandler);
        couponHandler.setHandler(null);

        order = new Order("0001", 20, "元");
        order.addPromotion(new Coupon(10, 2));
        order.addPromotion(new Integral(4));
        order.addPromotion(new RedEnvelope(8));
        order.addPromotion(new Coupon(2, 1));
        System.out.println(JSONUtil.toJsonStr(order));
        integralHandler.caculatePrice(order);
    }
}
