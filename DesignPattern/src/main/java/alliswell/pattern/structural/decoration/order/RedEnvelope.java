package alliswell.pattern.structural.decoration.order;

import java.math.BigDecimal;

/**
 * 红包
 *
 * @author chengxs
 * @date 2020/11/19
 */
public class RedEnvelope extends PromotionDecorator {

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
        System.out.println("红包价格抵消："+ this.getRedPrice());
        return discountPrice.subtract(BigDecimal.valueOf(this.getRedPrice())).doubleValue();
    }
}
