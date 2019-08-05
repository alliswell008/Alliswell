package alliswell.pattern.adapter;

/**
 * 定义适配器的标准接口，这样适配器就只能提供下面的接口
 */
public interface Targetable {
    /**
     * 目标接口，或称为标准接口
     */
    void request();

    /**
     * 新增方法功能
     */
    void request2();
}
