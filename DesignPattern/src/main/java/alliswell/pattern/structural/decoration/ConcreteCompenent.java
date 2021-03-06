/**
 * @Title: ConcreteCompenent
 * @Package org.alliswell.pattern.structural.decoration
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2017/1/17 10:44
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package alliswell.pattern.structural.decoration;

/**
 * @author alliswell008
 * @ClassName: ConcreteCompenent
 * @Description: 好处就是不依赖装饰者
 * @date 2017/1/17 10:44
 */
public class ConcreteCompenent extends Compenent {

    public ConcreteCompenent(){
        name = "鸡腿堡";
    }

    @Override
    public double getPrice() {
        System.out.println("鸡腿堡");
        return 10;
    }
}
