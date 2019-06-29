/**
 * @Title: ReducePrice20to10
 * @Package org.org.alliswell.cashregister.simplefactory.valution
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2016/11/24 21:41
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package alliswell.cashregister.simplefactory.valution;

/**
 * @author alliswell008
 * @ClassName: ReducePrice20to10
 * @Description: TODO(用一句话来说明)
 * @date 2016/11/24 21:41
 */
public class ReducePrice20to10 extends Valution {
    /* (非 Javadoc)
 * <p>Title: get总价</p>
 * <p>Description: </p>
 * @return
 * @see 商场收银软件.计价方式.计价方式#get总价()
 */
    @Override
    public double get总价() {
        // TODO Auto-generated method stub
        return 单价 * 数量 > 20 ? 单价 * 数量 - 10 : 单价 * 数量;
    }
}
