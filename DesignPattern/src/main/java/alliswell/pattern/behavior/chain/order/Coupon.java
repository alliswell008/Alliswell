package alliswell.pattern.behavior.chain.order;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/25
 */
public class Coupon extends Promotion {
    private String name;

    private double overPrice;

    private double minusPrice;

    private String unit;



    public Coupon() {
        this.name = "优惠券";
        this.unit = "元";
    }

    public Coupon(double overPrice, double minusPrice) {
        this();
        this.overPrice = overPrice;
        this.minusPrice = minusPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
