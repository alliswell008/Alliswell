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

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: ArraysDemo
 * @Description: Arrays.asList返回的Arrays中的内部类，只是类名也是ArrayList，不同于{@link java.util.ArrayList}
 * @author org.alliswell
 * @date 2016-11-20 下午1:58:07
 *
 */
public class ArraysDemo {
    public static void main(String[] args) {
        String[] str = new String[]{"you", "me"};
        List<String> list = Arrays.asList(str);
        // 实际是一个数组
        list.add("11");
    }
}
