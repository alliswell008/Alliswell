package alliswell.pattern.structural.composite.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品
 *
 * @author chengxs
 * @date 2020/11/19
 */
public class Ware implements Marketable {

    List<Marketable> wares = new ArrayList<>();

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

    @Override
    public void add(Marketable ware) {
        wares.add(ware);
    }

    @Override
    public void remove(Marketable ware) {
        wares.add(ware);
    }

    @Override
    public double display(int depth) {

        String sp = "";
        for (int j = 0; j < depth; j++) {
            sp += "-";
        }
        System.out.println(sp+"商品名称："+this.getName()+"，商品价格："+this.getPrice()+this.getUnit());
        BigDecimal price = this.getUnitPrice(this.getUnit(), this.getPrice().doubleValue());
        for (Marketable c : wares) {
            depth = depth + 2 ;
            double d = c.display(depth);
            depth = depth - 2 ;
            if (c instanceof Ware) {
                Ware w = (Ware) c;
                BigDecimal unitPrice = this.getUnitPrice(w.getUnit(), d);
                price = price.add(unitPrice);
            } else {
                BigDecimal ret = BigDecimal.ZERO;
                if (c instanceof Integral) {
                    ret =  this.getUnitPrice(((Integral)c).getUnit(), d);
                } else {
                    ret = BigDecimal.valueOf(d);
                }
                price = price.subtract(ret);
            }
        }
        return price.doubleValue();
    }

    /**
     * 统一单位为”元“
     *
     * @param unit
     * @param price
     * @return
     */
    private BigDecimal getUnitPrice(String unit, double price) {
        int ratio = 1;
        switch (unit) {
            case "元":
                break;
            case "角":
                ratio = 10;
                break;
            case "分":
                ratio = 100;
                break;
        }

        return BigDecimal.valueOf(price).divide(BigDecimal.valueOf(ratio), 2, BigDecimal.ROUND_HALF_UP);
    }
}
