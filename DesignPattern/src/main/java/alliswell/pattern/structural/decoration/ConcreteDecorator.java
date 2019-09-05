/**
 * @Title: ConcreteDecorator
 * @Package org.alliswell.pattern.structural.decoration
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2017/1/17 10:45
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
 * @ClassName: ConcreteDecorator
 * @Description: TODO(用一句话来说明)
 * @date 2017/1/17 10:45
 */
public class ConcreteDecorator extends Decorator {
    Compenent humburger;

    public ConcreteDecorator(Compenent humburger){
        this.humburger = humburger;
    }

    @Override
    public String getName() {
        return humburger.getName()+" 加生菜";
    }

    @Override
    public double getPrice() {
        return humburger.getPrice()+1.5;
    }

}
