package org.alliswell.core.mgrpromotion.dao;

import java.util.List;

/**
 * Created by alliswell008 on 2016/11/21.
 */
public interface PromotionDao {
	/**
	 * 录入促销规则
	 */
	public void addPromotionRule(Object obj);

	public void addPromotionRules(List<?> list);

	public void delPromotionRuleById(String ruleId);

	public void delPromotionRules(List<?> list);

	public void updPromotionRuleById(String ruleId);

	public void updPromotionRules(List<?> list);

	public Object queryPromotionRuleByWareId(String wareId);

	public List<?> queryPromotionRules(String condition);
}
