package alliswell.pattern.structural.composite.order;

import alliswell.pattern.structural.decoration.order.PromotionDecorator;

import java.math.BigDecimal;

/**
 * 积分
 *
 * @author chengxs
 * @date 2020/11/19
 */
public class Integral extends PromotionDecorator implements Marketable {

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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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

    @Override
    public void add(Marketable ware) {

    }

    @Override
    public void remove(Marketable ware) {

    }

    @Override
    public double display(int depth) {
        String sp = "";
        for (int j = 0; j < depth; j++) {
            sp += "-";
        }
        System.out.println(sp+"积分价格："+this.getIntegral()+this.getUnit());
        return this.getIntegral();
    }
}
