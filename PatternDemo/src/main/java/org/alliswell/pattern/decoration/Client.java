/**
 * @Title: Client
 * @Package org.alliswell.pattern.decoration
 * @Description: TODO(用一句话来说�?)
 * @author alliswell008
 * @date 2017/1/17 10:49
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
 * @ClassName: Client
 * @Description: 装饰模式
 * @date 2017/1/17 10:49
 */
public class Client {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // 汉堡
        Compenent humburger = new ConcreteCompenent();
        System.out.println(humburger.getName()+"  价钱�?"+humburger.getPrice());
        // +生菜
        ConcreteDecorator lettuce = new ConcreteDecorator(humburger);
        System.out.println(lettuce.getName()+"  价钱�?"+lettuce.getPrice());
        // +辣椒
        ConcreteDecorator2 chilli = new ConcreteDecorator2(humburger);
        System.out.println(chilli.getName()+"  价钱�?"+chilli.getPrice());
        // +生菜+辣椒
        ConcreteDecorator2 chilli2 = new ConcreteDecorator2(lettuce);
        System.out.println(chilli2.getName()+"  价钱�?"+chilli2.getPrice());
    }
}
