package alliswell.pattern.structural.composite.order;

import alliswell.pattern.structural.composite.Component;
import alliswell.pattern.structural.decoration.order.Coupon;
import alliswell.pattern.structural.decoration.order.Integral;
import alliswell.pattern.structural.decoration.order.Promotion;
import alliswell.pattern.structural.decoration.order.PromotionDecorator;
import alliswell.pattern.structural.decoration.order.RedEnvelope;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单
 *
 * @author chengxs
 * @date 2020/11/19
 */
public class Order implements Marketable {

    List<Marketable> wares = new ArrayList<>();

    List<Ware> wareList = new ArrayList<>(10);
    List<Promotion> promotionList = new ArrayList<>(10);
    /**
     * 订单号
     */
    private String orderNum;
    private double value;
    private String unit;

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

    public void addWare(Ware ware) {
        wareList.add(ware);

        BigDecimal orderPrice = BigDecimal.ZERO;
        // 计算商品的价格
        for (Ware w : wareList) {
            if ("元".equals(w.getUnit())) {
                orderPrice = orderPrice.add(w.getPrice());
            } else if ("角".equals(w.getUnit())){
                orderPrice = orderPrice.add(w.getPrice().divide(BigDecimal.valueOf(10), 2, BigDecimal.ROUND_HALF_UP));
            } else if ("分".equals(w.getUnit())) {
                orderPrice = orderPrice.add(w.getPrice().divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_HALF_UP));
            }
        }
        this.setValue(orderPrice.doubleValue());
    }

    public void addPromotion(Promotion promotion) {
        promotionList.add(promotion);

//        double orderPrice = 0D;
//        for (Promotion p : promotionList) {
//            orderPrice = p.getDiscountPrice();
//        }
//        this.setValue(orderPrice);
        this.chooseOptimalPromotion();
    }

    public void chooseOptimalPromotion() {
        Map<Double, List> map = new HashMap<>();
        List<Double> list = new ArrayList<>();
        List<Coupon> couponList = new ArrayList<>();
        List<Integral> integralList = new ArrayList<>();
        List<RedEnvelope> redEnvelopeList = new ArrayList<>();
        for (Promotion p : promotionList) {
            // 同一类型只能用一个
            switch (p.getType()) {
                case "1":
                    couponList.add((Coupon) p); break;
                case "2":
                    integralList.add((Integral) p); break;
                case "3":
                    redEnvelopeList.add((RedEnvelope) p); break;
            }
        }

        PromotionDecorator priceDecorator = new PromotionDecorator() {
            @Override
            public double getDiscountPrice() {
                System.out.println("订单价格："+getValue());
                return getValue();
            }
        };
        for (Coupon cp : couponList) {
            cp.setPromotion(priceDecorator);
            for (Integral ip : integralList) {
                ip.setPromotion(cp);
                for (RedEnvelope rp : redEnvelopeList) {
                    rp.setPromotion(ip);
                    double discountPrice = rp.getDiscountPrice();
                    list.add(discountPrice);
                    List<Promotion> l = new ArrayList<>();
                    l.add(cp);
                    l.add(ip);
                    l.add(rp);
                    map.put(discountPrice, l);
                }
            }
        }
        if (!list.isEmpty()) {
            Double min = Collections.min(list);
            System.out.println("最小值：" + min);
            System.out.println("最小值列表：" + map.get(min));
        }

    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNum='" + orderNum + '\'' +
                "value='" + this.getValue() + '\'' +
                "unit='" + this.getUnit() + '\'' +
                ", wareList=" + wareList +
                ", priceList=" + promotionList +
                '}';
    }

    @Override
    public void add(Marketable ware) {
        wares.add(ware);
    }

    @Override
    public void remove(Marketable ware) {
        wares.remove(ware);
    }

    @Override
    public double display(int depth) {
        System.out.println("订单价格："+this.getValue());
        BigDecimal price = BigDecimal.ZERO;
        for (Marketable c : wares) {
            depth = depth + 2 ;
            double d = c.display(depth);
            depth = depth - 2 ;
            if (c instanceof Ware) {
                price = price.add(BigDecimal.valueOf(d));
            } else {
                price = price.subtract(BigDecimal.valueOf(d));
            }
        }
        this.setValue(price.doubleValue());
        System.out.println("订单价格："+this.getValue());
        return price.doubleValue();
    }
}
