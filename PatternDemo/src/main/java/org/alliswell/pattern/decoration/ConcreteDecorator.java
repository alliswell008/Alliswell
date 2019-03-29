/**
 * @Title: ConcreteDecorator
 * @Package org.alliswell.pattern.decoration
 * @Description: TODO(用一句话来说�?)
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
package src.main.java.org.alliswell.pattern.decoration;

/**
 * @author alliswell008
 * @ClassName: ConcreteDecorator
 * @Description: TODO(用一句话来说�?)
 * @date 2017/1/17 10:45
 */
public class ConcreteDecorator extends Decorator {
    Compenent humburger;

    public ConcreteDecorator(Compenent humburger){
        this.humburger = humburger;
    }

    @Override
    public String getName() {
        return humburger.getName()+" 加生�?";
    }

    @Override
    public double getPrice() {
        return humburger.getPrice()+1.5;
    }

}
