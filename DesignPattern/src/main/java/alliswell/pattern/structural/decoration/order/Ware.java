package alliswell.pattern.structural.decoration.order;

import java.math.BigDecimal;

/**
 * 商品
 *
 * @author chengxs
 * @date 2020/11/19
 */
public class Ware {
    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 价格单位
     */
    private String unit;

    public Ware(String name, double price, String unit) {
        this.name = name;
        this.price = new BigDecimal(price);
        this.unit = unit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Ware{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", unit='" + unit + '\'' +
                '}';
    }
}
