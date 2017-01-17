package org.alliswell.core.mgrware.dao;

import org.alliswell.core.mgrware.model.entity.WareEntity;
import org.alliswell.core.mgrware.model.vo.WareVo;

import java.util.List;

/**
 * @ Title: WareDao
 * @ Package org.org.alliswell.core.dao.mgrware
 * @ Description: 商品Dao层
 * @ author org.alliswell
 * @ date 2016/11/21 23:09
 * @ version V1.0
 * @ Update_Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
public interface WareDao {

    /**
     * 新增一个商品
     * @param wareEntity
     * @return
     */
    public int insert(WareEntity wareEntity);

    /**
     * 新增多个商品
     * @param wareEntityList
     * @return
     */
    public int insertList(List<WareEntity> wareEntityList);

    /**
     * 删除一个商品
     * @param wareEntity
     * @return
     */
    public int delete(WareEntity wareEntity);

    /**
     * 删除多个商品
     * @param wareEntityList
     * @return
     */
    public int deleteList(List<WareEntity> wareEntityList);

    /**
     * 通过商品id删除商品
     * @param wareId
     * @return
     */
    public int delete(String... wareId);

    /**
     * 修改一个商品
     * @param wareEntity
     * @return
     */
    public int update(WareEntity wareEntity);

    /**
     * 修改多个商品
     * @param wareEntityList
     * @return
     */
    public int updateList(List<WareEntity> wareEntityList);

    /**
     * 通过商品id修改商品
     * @param wareId
     * @return
     */
    public int update(String... wareId);

    /**
     * 查询商品列表
     * @param userId
     * @param areaId
     * @param wareType
     */
    public List<WareVo> queryList(String userId, String areaId, String wareType);

    /**
     * 查询商品详情
     * @param wareId
     * @param wareType
     */
    public WareVo queryDetail(String wareId, String wareType);

    /**
     * 通过商品id查询商品
     * @param wareId
     */
    public WareVo query(String... wareId);

}
