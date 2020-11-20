package alliswell.pattern.structural.decoration.order;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/19
 */
public class Main {
    public static void main(String[] args) {
        Order order = new Order();
        order.setOrderNum("000001");
        order.addWare(new Ware("商品1", 1,"元"));
        order.addWare(new Ware("商品2", 2,"分"));
        order.addWare(new Ware("商品3", 5,"角"));
        order.addWare(new Ware("商品4", 10,"元"));
        order.setUnit("元");
        System.out.println(order.getValue());
        System.out.println(order.toString());

        Coupon coupon1 = new Coupon(15D, 3D);
        RedEnvelope redEnvelope1 = new RedEnvelope(4D);
        Integral integral1 = new Integral(400D);

        Coupon coupon2 = new Coupon(7D, 1D);
        RedEnvelope redEnvelope2 = new RedEnvelope(2D);
        Integral integral2 = new Integral(200D);

        Coupon coupon3 = new Coupon(6D, 3D);

        order.addPromotion(coupon1);
        order.addPromotion(redEnvelope1);
        order.addPromotion(integral1);

        order.addPromotion(redEnvelope2);
        order.addPromotion(integral2);
        order.addPromotion(coupon2);

        order.addPromotion(coupon3);

        System.out.println(order.getValue());
        System.out.println(order.toString());


    }
}
