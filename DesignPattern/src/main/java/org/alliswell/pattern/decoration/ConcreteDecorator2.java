/**
 * @Title: ConcreteDecorator
 * @Package org.alliswell.pattern.decoration
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
package org.alliswell.pattern.decoration;

/**
 * @author alliswell008
 * @ClassName: ConcreteDecorator
 * @Description: TODO(用一句话来说明)
 * @date 2017/1/17 10:45
 */
public class ConcreteDecorator2 extends Decorator {
    Compenent humburger;

    public ConcreteDecorator2(Compenent humburger){
        this.humburger = humburger;
    }

    @Override
    public String getName() {
        return humburger.getName()+" 加辣椒";
    }

    @Override
    public double getPrice() {
        return humburger.getPrice();  //辣椒是免费的哦
    }

}
