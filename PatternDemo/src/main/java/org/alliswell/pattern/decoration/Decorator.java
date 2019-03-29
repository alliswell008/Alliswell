/**
 * @Title: Decoration
 * @Package org.alliswell.pattern.decoration
 * @Description: TODO(用一句话来说�?)
 * @author alliswell008
 * @date 2017/1/17 10:39
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package src.main.java.org.alliswell.pattern.decoration;

/**
 * @author alliswell008
 * @ClassName: Decoration
 * @Description: TODO(用一句话来说�?)
 * @date 2017/1/17 10:39
 */
public abstract class Decorator extends Compenent {
    // 装饰者如果不继承组件，那么就不能多次装饰；因为继承使得装饰�?�本身也可被视为被装饰�?�，以使装饰者可以互相装�?
    public abstract String getName();
}
