package org.alliswell.core.mgrware.service;

import org.alliswell.core.mgrware.model.vo.WareVo;

import java.util.List;

/**
 * @ Title: WareService
 * @ Package org.org.alliswell.core.service.mgrware
 * @ Description: 商品Service接口层
 * @ author org.alliswell
 * @ date 2016/11/21 23:12
 * @ version V1.0
 * @ Update_Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
public interface WareService {

	/**
	 * 查询商品列表
	 *
	 * @param userId
	 * @param areaId
	 * @param wareType
	 */
	public List<WareVo> queryWareList(String userId, String areaId, String wareType);

	/**
	 * 查询商品详情
	 *
	 * @param wareId
	 * @param wareType
	 */
	public WareVo queryWareDetail(String wareId, String wareType);
}
