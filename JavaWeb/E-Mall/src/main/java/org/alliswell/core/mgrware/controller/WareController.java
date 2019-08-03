package org.alliswell.core.mgrware.controller;

import org.alliswell.core.mgrware.service.WareService;

/**
 * @ Title: WareController
 * @ Package org.org.alliswell.core.api.mgrware
 * @ Description: 商品Controller层
 * @ author org.alliswell
 * @ date 2016/11/21 23:07
 * @ version V1.0
 * @ Update_Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
public class WareController {

	private WareService wareService;

	/**
	 * 获取商品列表
	 *
	 * @param userId
	 * @param areaId
	 * @param wareType
	 */
	public void getWareList(String userId, String areaId, String wareType) {
		wareService.queryWareList(userId, areaId, wareType);
	}

	/**
	 * 获取商品详情
	 *
	 * @param wareId
	 * @param wareType
	 */
	public void getWareDetail(String wareId, String wareType) {
		wareService.queryWareDetail(wareId, wareType);
	}
}
