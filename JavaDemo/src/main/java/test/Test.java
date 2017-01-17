/**
 * @Title: Test
 * @Package test
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2016/12/12 17:07
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package test;

/**
 * @author alliswell008
 * @ClassName: Test
 * @Description: （x++)/3是先执行x/3的操作，就相当于先执行2/3，/操作取结果的整数部分，
 *                所以是0，这些操作完成之后才会将+1的值赋值给x。你如果将x++换成++x,
 *                就是先将+1的值赋给x（此时x）,再进行3/3操作，此时在运行，结果为1
 * @date 2016/12/12 17:07
 */
public class Test {
    public static void main(String args[]){
        int x=2,t=0;
        t=(x++)/3;
        System.out.println(t);
        System.out.println(x);

        x=2;
        t=(++x)/3;
        System.out.println(t);
        System.out.println(x);
    }
}