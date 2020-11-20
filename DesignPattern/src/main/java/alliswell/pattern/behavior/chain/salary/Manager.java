package alliswell.pattern.behavior.chain.salary;

/**
 * 抽象管理者
 *
 * @author chengxs
 * @date 2020/11/10
 */
public abstract class Manager {
    /**
     * 管理者名称
     */
    protected String name;

    /**
     * 上级管理者
     */
    protected Manager superior;

    public Manager(String name) {
        this.name = name;
    }

    /**
     * 设置上级管理者
     *
     * @param superior
     */
    public void setSuperior(Manager superior) {
        this.superior = superior;
    }

    abstract public void requestApplications(Request request);
}
