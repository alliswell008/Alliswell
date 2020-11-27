package alliswell.pattern.behavior.chain.order;

/**
 * 红包
 *
 * @author chengxs
 * @date 2020/11/19
 */
public class RedEnvelope extends Promotion {

    private String name;

    private double redPrice;

    private String unit;


    public RedEnvelope() {
        this.name = "红包";
        this.unit = "元";
    }

    public RedEnvelope(double redPrice) {
        this();
        this.redPrice = redPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                '}';
    }

}
