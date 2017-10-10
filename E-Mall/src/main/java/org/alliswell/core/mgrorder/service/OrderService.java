package org.alliswell.core.mgrorder.service;

import org.alliswell.domain.order.Order;

/**
 * @ Title: OrderService
 * @ Package org.org.alliswell.core.service.mgrorder
 * @ Description: TODO(用一句话描述该文件做什么)
 * @ author org.alliswell
 * @ date 2016/11/21 23:11
 * @ version V1.0
 * @ Update_Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
public interface OrderService {
    void generateOrder(String account, Order order);
}
