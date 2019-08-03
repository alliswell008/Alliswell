package org.alliswell.core.mgrpromotion.service;

/**
 * Created by alliswell008 on 2016/11/21.
 */
public interface PromotionService {
	/**
	 * 生成促销规则
	 */
	public void addPromotionRule();

	public void delPromotionRule();

	public void delPromotionRuleById();

	public void updPromotionRule();

	public void updPromotionRuleById();

	public void queryPromotionRules();

	public void queryPromotionRuleByWareId();
}
