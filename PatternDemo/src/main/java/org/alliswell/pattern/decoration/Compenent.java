/**
 * @Title: Compenent
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
 * @ClassName: Compenent
 * @Description: TODO(用一句话来说�?)
 * @date 2017/1/17 10:39
 */
public abstract class Compenent {

    protected  String name ;

    public String getName(){
        return name;
    }

    public abstract double getPrice();
}
