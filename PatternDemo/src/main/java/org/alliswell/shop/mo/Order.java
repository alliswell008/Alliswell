/**
 * @Title: Order
 * @Package org.alliswell.shop
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2017/1/17 12:16
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package org.alliswell.shop.mo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alliswell008
 * @ClassName: Order
 * @Description: 订单
 * @date 2017/1/17 12:16
 */
public class Order extends Ware {

    List<Ware> goods = new ArrayList<>();

    /**
     * @param goods 要设置的 goods
     */
    public void setGoods(Ware goods) {
        this.goods.add(goods);
    }

    public List<Ware> getGoods(){
        return this.goods;
    }

    @Override
    public void add(Ware c) {
        this.goods.add(c);
    }

    @Override
    public void remove(Ware c) {
        this.goods.remove(c);
    }

    @Override
    public double display(int depth) {
        return 0;
    }

}
