/**
 * @Title: DyadicArrayDemo.java
 * @Package org.org.alliswell.demo.array
 * @Description: 数组的使用
 * @author org.alliswell
 * @date 2016-11-20 下午1:58:07
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package alliswell.demo.array;

/**
 * @ClassName: DyadicArrayDemo
 * @Description: 二位数组的长度
 * @author org.alliswell
 * @date 2016-11-20 下午1:58:07
 *
 */
public class DyadicArrayDemo {
    public static void main(String[] args) {
        String[][] dyadicArray = null;

        dyadicArray = new String[2][3];
        dyadicArray[0][0] = "a";
        dyadicArray[0][1] = "a";
        dyadicArray[0][2] = "a";

        System.out.println(dyadicArray[0][2]);
        System.out.println(dyadicArray.length);// 输出：2，而非3
        System.out.println(dyadicArray[0].length);// 输出：3，而非2
        System.out.println(dyadicArray[0][0].length());// 输出：1
    }
}
