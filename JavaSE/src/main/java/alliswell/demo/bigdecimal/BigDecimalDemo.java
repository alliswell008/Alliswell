/**
 * @Title: BigDecimalDemo.java
 * @Package org.org.alliswell.demo.bigdecimal
 * @Description: 大数值的转化
 * @author org.alliswell
 * @date 2016-11-20 下午1:48:40
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package alliswell.demo.bigdecimal;

import java.math.BigDecimal;

/**
 * @ClassName: BigDecimalDemo
 * @Description: 当一个数据大于等于一千万时，通过String.valueOf()会转成科学计数
 * @author org.alliswell
 * @date 2016-11-20 下午1:48:40
 *
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
//		double dNum = 12345678.0123769;
//        double dNum = 10000000;
//		float dNum = 10000000;
        double dNum = 8.01237695456573328F;

        //基础类型的大数转化为String时会自动转为二进制科学计数法的形式
        System.out.println(dNum);
        System.out.println(String.valueOf(dNum));
        //若以BigDecimal类来转化则不会转为二进制科学计数的形式，但小数位数未受控制
        System.out.println(new BigDecimal(Double.toString(dNum)).toString());
        //若以BigDecimal类来转化并设置小数点后的有效位，以及进位（四舍五入）
        System.out.println(new BigDecimal(Double.toString(dNum)).setScale(5, BigDecimal.ROUND_HALF_UP).toString());
    }

}
