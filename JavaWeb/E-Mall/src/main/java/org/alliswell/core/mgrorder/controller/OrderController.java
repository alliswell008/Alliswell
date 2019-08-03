package org.alliswell.core.mgrorder.controller;

import org.alliswell.core.mgrorder.service.OrderService;
import org.alliswell.core.mgrorder.service.impl.OrderServiceImpl;
import org.alliswell.domain.order.Order;
import org.alliswell.domain.order.OrderFactory;

/**
 * @ Title: OrderController
 * @ Package org.org.alliswell.core.api.mgrorder
 * @ Description: TODO(用一句话描述该文件做什么)
 * @ author org.alliswell
 * @ date 2016/11/21 23:03
 * @ version V1.0
 * @ Update_Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
public class OrderController {

	/**
	 * 生成订单
	 *
	 * @param account   用户账号
	 * @param accType   账号类型 APP:app用户，ST
	 * @param orderType 订单类型
	 * @param orderJson 订单json参数
	 */
	public void generateOrder(String account, String accType, String orderType, String orderJson) {

		Order order = OrderFactory.createOrder(orderType, orderJson);

		if ("".equals(accType)) {

			OrderService orderService = new OrderServiceImpl();

			orderService.generateOrder(account, order);
		} else {

		}

	}
}
