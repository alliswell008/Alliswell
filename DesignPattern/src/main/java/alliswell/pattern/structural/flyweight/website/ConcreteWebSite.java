package alliswell.pattern.structural.flyweight.website;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/25
 */
public class ConcreteWebSite extends WebSite {
    private String name;

    public ConcreteWebSite(String name) {
        this.name = name;
    }

    @Override
    public void use(User user) {
        System.out.println(String.format("网站分类：%s 用户：%s",name, user.getName()));
    }
}
