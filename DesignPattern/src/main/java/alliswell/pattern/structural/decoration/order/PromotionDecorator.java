package alliswell.pattern.structural.decoration.order;

/**
 * 抽象装饰者
 *
 * @author chengxs
 * @date 2020/11/19
 */
public abstract class PromotionDecorator extends Promotion {

    protected Promotion component;

    public void setPromotion(Promotion component) {
        this.component = component;
    }
}
