package alliswell.pattern.structural.composite.organization;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/12/1
 */
public class FinanceDepartment extends Company {

    public FinanceDepartment(String name) {
        super(name);
    }

    @Override
    public void add(Company company) {

    }

    @Override
    public void remove(Company company) {

    }

    @Override
    public void display(int depth) {
        String sp = "";
        for (int j = 0; j < depth; j++) {
            sp += "-";
        }
        System.out.println(sp + name);
    }

    @Override
    public void lineOfDuty() {
        System.out.println(String.format("%s 公司财务收支管理", name));
    }
}
