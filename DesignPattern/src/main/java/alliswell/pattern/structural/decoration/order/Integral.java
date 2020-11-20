package alliswell.pattern.structural.decoration.order;

import java.math.BigDecimal;

/**
 * 积分
 *
 * @author chengxs
 * @date 2020/11/19
 */
public class Integral extends PromotionDecorator {

    private double integral;
    private String unit;

    public Integral() {
        this.name = "积分";
        this.unit = "分";
        this.type = "2";
    }

    public Integral(double integral) {
        this();
        this.integral = integral;
    }

    public double getIntegral() {
        return integral;
    }

    public void setIntegral(double integral) {
        this.integral = integral;
    }

    @Override
    public String toString() {
        return "Integral{" +
                "integral=" + integral +
                ", unit='" + unit + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", quantity='" + quantity + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    @Override
    public double getDiscountPrice() {
        BigDecimal discountPrice = BigDecimal.valueOf(component.getDiscountPrice());
        System.out.println("积分价格抵消："+ (this.getIntegral()/100));
        return discountPrice.subtract(BigDecimal.valueOf(this.getIntegral() / 100)).doubleValue();
    }
}
