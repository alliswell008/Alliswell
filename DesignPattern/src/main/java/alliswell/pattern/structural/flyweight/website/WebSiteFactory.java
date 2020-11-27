package alliswell.pattern.structural.flyweight.website;


import java.util.Hashtable;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/25
 */
public class WebSiteFactory {
    private Hashtable flyweights = new Hashtable();

    public WebSite getWebSiteCategory(String key) {
        if (!flyweights.contains(key)) {
            flyweights.put(key, new ConcreteWebSite(key));
        }
        return (WebSite) flyweights.get(key);
    }

    public int getWebSiteCount() {
        return flyweights.size();
    }
}
