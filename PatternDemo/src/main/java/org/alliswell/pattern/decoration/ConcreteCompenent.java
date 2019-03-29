/**
 * @Title: ConcreteCompenent
 * @Package org.alliswell.pattern.decoration
 * @Description: TODO(用一句话来说�?)
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
package src.main.java.org.alliswell.pattern.decoration;

/**
 * @author alliswell008
 * @ClassName: ConcreteCompenent
 * @Description: TODO(用一句话来说�?)
 * @date 2017/1/17 10:44
 */
public class ConcreteCompenent extends Compenent {

    public ConcreteCompenent(){
        name = "鸡腿�?";
    }

    @Override
    public double getPrice() {
        return 10;
    }
}
