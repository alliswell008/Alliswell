package alliswell.pattern.structural.composite.order;

import alliswell.pattern.structural.decoration.order.PromotionDecorator;

import java.math.BigDecimal;

/**
 * 红包
 *
 * @author chengxs
 * @date 2020/11/19
 */
public class RedEnvelope extends PromotionDecorator implements Marketable {

    private double redPrice;

    private String unit;

    public RedEnvelope() {
        this.name = "红包";
        this.unit = "元";
        this.type = "3";
    }

    public RedEnvelope(double redPrice) {
        this();
        this.redPrice = redPrice;
    }

    public double getRedPrice() {
        return redPrice;
    }

    public void setRedPrice(double redPrice) {
        this.redPrice = redPrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "RedEnvelope{" +
                "redPrice=" + redPrice +
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
        System.out.println("红包价格抵消：" + this.getRedPrice());
        return discountPrice.subtract(BigDecimal.valueOf(this.getRedPrice())).doubleValue();
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
        System.out.println(sp + "红包价格：" + this.getRedPrice()+this.getUnit());
        return this.getRedPrice();
    }
}
