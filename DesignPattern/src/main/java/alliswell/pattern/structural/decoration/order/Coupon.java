package alliswell.pattern.structural.decoration.order;

import java.math.BigDecimal;

/**
 * 优惠券
 *
 * @author chengxs
 * @date 2020/11/19
 */
public class Coupon extends PromotionDecorator {

    private double overPrice;

    private double minusPrice;

    private String unit;

    public Coupon() {
        this.name = "优惠券";
        this.unit = "元";
        this.type = "1";
    }

    public Coupon(double overPrice, double minusPrice) {
        this();
        this.overPrice = overPrice;
        this.minusPrice = minusPrice;
    }

    @Override
    public double getDiscountPrice() {
        BigDecimal discountPrice = BigDecimal.valueOf(component.getDiscountPrice());
        System.out.println(String.format("优惠券价格：满%s减%s", this.getOverPrice(), this.getMinusPrice()));
        if (discountPrice.doubleValue() >= this.getOverPrice()) {
            return discountPrice.subtract(BigDecimal.valueOf(this.getMinusPrice())).doubleValue();
        } else {
            return discountPrice.doubleValue();
        }
    }

    public double getOverPrice() {
        return overPrice;
    }

    public void setOverPrice(double overPrice) {
        this.overPrice = overPrice;
    }

    public double getMinusPrice() {
        return minusPrice;
    }

    public void setMinusPrice(double minusPrice) {
        this.minusPrice = minusPrice;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "overPrice=" + overPrice +
                ", minusPrice=" + minusPrice +
                ", unit=" + unit +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", quantity='" + quantity + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
