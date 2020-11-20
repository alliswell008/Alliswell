package alliswell.pattern.creational.factory;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/16
 */
public class SimpleFactory {
    public IProduct getProductA(){
        return new ProductA();
    }
    public IProduct getProductB(){
        return new ProductB();
    }
    public static IProduct getProduct(int type){
        if (type==1){
            return new ProductA();
        }else{
            return new ProductB();
        }
    }
}
