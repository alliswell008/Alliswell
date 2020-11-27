package alliswell.pattern.behavior.chain.order;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/25
 */
public class Integral extends Promotion {
    private String name;
    private double integral;
    private String unit;

    public Integral() {
        this.name = "积分";
        this.unit = "分";
    }

    public Integral(double integral) {
        this();
        this.integral = integral;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}
