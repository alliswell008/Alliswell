package alliswell.pattern.structural.composite.order;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/23
 */
public class Main {
    public static void main(String[] args) {
        Order order = new Order();

        Ware ware1 = new Ware("商品1", 1,"元");
        Ware ware2 = new Ware("商品2（积分商品）", 2,"分");
        Ware ware3 = new Ware("商品3", 5,"角");
        Ware ware4 = new Ware("商品4（优惠券商品）", 10,"元");
        order.add(ware1);
        order.add(ware2);
        order.add(ware3);
        order.add(ware4);

        RedEnvelope redEnvelope = new RedEnvelope(4D);
        order.add(redEnvelope);

        Coupon wareCoupon = new Coupon(7D, 1D);
        ware4.add(wareCoupon);

        Integral integral = new Integral(1D);
        ware2.add(integral);

        Ware ware5 = new Ware("商品5（赠品）", 1,"元");
        ware3.add(ware5);

        Coupon orderCoupon = new Coupon(7D, 2D);
        order.add(orderCoupon);

        double display = order.display(0);
        System.out.println(display);

    }
}
