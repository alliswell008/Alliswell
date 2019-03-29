/**
 * @Title: OrderBO
 * @Package org.alliswell.shop.bo
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2017/1/17 13:29
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package org.alliswell.shop.bo;

import org.alliswell.shop.mo.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alliswell008
 * @ClassName: OrderBO
 * @Description: TODO(用一句话来说明)
 * @date 2017/1/17 13:29
 */
public class OrderBO extends Order {
    protected String orderId;
    protected String orderBh;

    protected OrderChannelBo orderChannelBo;
    protected OrderPaymentBo orderPaymentBo;
    protected OrderBuyerBo orderBuyerBo;

    protected List<OrderWareBo> orderWareBoList = new ArrayList<OrderWareBo>();

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderBh() {
        return orderBh;
    }

    public void setOrderBh(String orderBh) {
        this.orderBh = orderBh;
    }

    public OrderChannelBo getOrderChannelBo() {
        return orderChannelBo;
    }

    public void setOrderChannelBo(OrderChannelBo orderChannelBo) {
        this.orderChannelBo = orderChannelBo;
    }

    public OrderPaymentBo getOrderPaymentBo() {
        return orderPaymentBo;
    }

    public void setOrderPaymentBo(OrderPaymentBo orderPaymentBo) {
        this.orderPaymentBo = orderPaymentBo;
    }

    public OrderBuyerBo getOrderBuyerBo() {
        return orderBuyerBo;
    }

    public void setOrderBuyerBo(OrderBuyerBo orderBuyerBo) {
        this.orderBuyerBo = orderBuyerBo;
    }

    public List<OrderWareBo> getOrderWareBoList() {
        return orderWareBoList;
    }

    public void setOrderWareBoList(List<OrderWareBo> orderWareBoList) {
        this.orderWareBoList = orderWareBoList;
    }
}
