package alliswell.pattern.structural.decoration.order;

import java.math.BigDecimal;

/**
 * 促销活动
 *
 * @author chengxs
 * @date 2020/11/19
 */
public abstract class Promotion {
    /**
     * 活动名称
     */
    protected String name;

    /**
     * 活动类型
     */
    protected String type;

    /**
     * 活动数量
     */
    protected String quantity;

    /**
     * 活动时间
     */
    protected String time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", quantity='" + quantity + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    /**
     * 优惠价格
     *
     * @return
     */
    public abstract double getDiscountPrice();
}
