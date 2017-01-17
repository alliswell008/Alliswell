/**
 * @Title: OrderWare
 * @Package org.alliswell.shop.bo
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2017/1/17 13:31
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package org.alliswell.shop.bo;

/**
 * @author alliswell008
 * @ClassName: OrderWare
 * @Description: TODO(用一句话来说明)
 * @date 2017/1/17 13:31
 */
public class OrderWareBo {
    protected String wareId;
    protected String wareName;

    protected WareSpecificationBo wareSpecificationBo;
    protected WareSellerBo wareSellerBo;
    protected WarePromotionBo warePromotionBo;

    public String getWareId() {
        return wareId;
    }

    public void setWareId(String wareId) {
        this.wareId = wareId;
    }

    public String getWareName() {
        return wareName;
    }

    public void setWareName(String wareName) {
        this.wareName = wareName;
    }

    public WareSpecificationBo getWareSpecificationBo() {
        return wareSpecificationBo;
    }

    public void setWareSpecificationBo(WareSpecificationBo wareSpecificationBo) {
        this.wareSpecificationBo = wareSpecificationBo;
    }

    public WareSellerBo getWareSellerBo() {
        return wareSellerBo;
    }

    public void setWareSellerBo(WareSellerBo wareSellerBo) {
        this.wareSellerBo = wareSellerBo;
    }

    public WarePromotionBo getWarePromotionBo() {
        return warePromotionBo;
    }

    public void setWarePromotionBo(WarePromotionBo warePromotionBo) {
        this.warePromotionBo = warePromotionBo;
    }
}
