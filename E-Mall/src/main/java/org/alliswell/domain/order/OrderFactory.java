package org.alliswell.domain.order;

import org.alliswell.base.exception.OrderException;
import org.alliswell.base.utils.OrderTypeEnum;
import org.alliswell.domain.order.vo.paa.PAAOrderVO;
import org.alliswell.domain.order.vo.pcz.PCZOrderVO;

/**
 * 订单工厂
 * Created by cxs on 2017/8/31.
 */
public class OrderFactory {


    /**
     * 订单工厂创建订单
     *
     * @param type      订单类型
     * @param orderJson 订单json参数
     * @return
     */
    public static Order createOrder(String type, String orderJson) {
        Order order = null;


        if (OrderTypeEnum.valueOf(type).ordinal() == -1) {
            throw new OrderException("无效的订单类型");
        }

        switch (type) {
            case "PAA":
                order = new PAAOrderVO();
                break;

            case "PCZ":
                order = new PCZOrderVO();
                break;

            default:
                break;
        }

        return order;
    }
}
