package org.alliswell.core.mgrware.service.impl;

import org.alliswell.core.mgrware.dao.WareDao;
import org.alliswell.core.mgrware.model.vo.WareVo;
import org.alliswell.core.mgrware.service.WareService;

import java.util.List;

/**
 * @ Title: WareServiceImpl
 * @ Package org.org.alliswell.core.service.impl.mgrware
 * @ Description: 商品Service实现层
 * @ author org.alliswell
 * @ date 2016/11/21 23:13
 * @ version V1.0
 * @ Update_Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
public class WareServiceImpl implements WareService {
	private WareDao wareDao;

	@Override
	public List<WareVo> queryWareList(String userId, String areaId, String wareType) {
		return wareDao.queryList(userId, areaId, wareType);
	}

	@Override
	public WareVo queryWareDetail(String wareId, String wareType) {
		return wareDao.queryDetail(wareId, wareType);
	}
}
