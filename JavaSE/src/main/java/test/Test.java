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

import sun.misc.VM;

/**
 * @author alliswell008
 * @ClassName: Test
 * @Description:
 * @date 2016/12/12 17:07
 */
public class Test {

    public static void main(String args[]){
        getResult();

        // 值传递
        String a = "1";
        chuandi(a);
        System.out.println("方法外a=" + a);


        String host = "172.16.145.159";

        String ff = !host.equals("127.0.0.1") && !host.startsWith("localhost") && !host.equals("0.0.0.0") && !host.startsWith("169.254") && !host.startsWith("::1") && !host.startsWith("0:0:0:0:0:0:0:1")?host:"";
        System.out.println(ff);


    }

    /**
     * （x++)/3是先执行x/3的操作，就相当于先执行2/3，/操作取结果的整数部分，
     *  所以是0，这些操作完成之后才会将+1的值赋值给x。你如果将x++换成++x,
     *  就是先将+1的值赋给x（此时x）,再进行3/3操作，此时在运行，结果为1
     */
    static void getResult() {
        int x=2,t1=0,t2;
        t1=(x++)/3;

        x=2;
        t2=(++x)/3;

        System.out.println("t1="+t1+",t2="+t2);
    }

    static void chuandi(String a) {
        String b = "2";
        a = new String(b);
        System.out.println("方法内a=" + a);
    }
}