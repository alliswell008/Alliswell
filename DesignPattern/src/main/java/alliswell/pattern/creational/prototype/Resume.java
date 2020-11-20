package alliswell.pattern.creational.prototype;

/**
 * 简历
 *
 * @author chengxs
 * @date 2020/11/10
 */
public class Resume implements Cloneable {

    private String name;
    private String sex;
    private String age;
    private String tiemArea;
    private String company;

    public Resume(String name) {
        this.name = name;
    }

    /**
     * 设置个人信息
     *
     * @param sex
     * @param age
     */
    public void setPersionalInfo(String sex, String age) {
        this.sex = sex;
        this.age = age;
    }

    /**
     * 设置个人信息
     *
     * @param tiemArea
     * @param company
     */
    public void setWorkExperience(String tiemArea, String company) {
        this.tiemArea = tiemArea;
        this.company = company;
    }

    public void display() {
        System.out.println(String.format("%s %s %s", name, sex, age));
        System.out.println(String.format("工作经历：%s %s", tiemArea, company));
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
