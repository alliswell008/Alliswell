package alliswell.pattern.structural.composite.organization;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/12/1
 */
public abstract class Company {
    protected String name;

    public Company(String name) {
        this.name = name;
    }

    public abstract void add(Company company);
    public abstract void remove(Company company);
    public abstract void display(int depth);
    public abstract void lineOfDuty();
}
