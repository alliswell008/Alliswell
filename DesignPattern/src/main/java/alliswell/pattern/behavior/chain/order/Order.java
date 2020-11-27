package alliswell.pattern.behavior.chain.order;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/25
 */
public class Order {

    private List<Promotion> promotionList = new ArrayList<>();
    /**
     * 订单号
     */
    private String orderNum;
    private double value;
    private String unit;

    public Order(String orderNum, double value, String unit) {
        this.orderNum = orderNum;
        this.value = value;
        this.unit = unit;
    }

    public List<Promotion> getPromotionList() {
        return promotionList;
    }

    public void addPromotion(Promotion promotion) {
        promotionList.add(promotion);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }
}
