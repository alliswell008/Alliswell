package test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 空对象靠右原则可以避免NPE异常
 *
 * @author chengxs
 * @date 2019/6/29
 */
public class Test6 {

    public static void main(String[] args) {
        Integer num = null;

        // 避免NPE
        if (new Integer(8).equals(num)) {
            System.out.println("==");
        } else {
            System.out.println("!=");
        }

        boolean e = Objects.equals(8, new Integer(8));
        System.out.println(e);

        String[] str = new String[]{"you", "me"};
        List list = Arrays.asList(str);
        // 实际是一个数组
        list.add("11");

        // 抛出异常NPE
        boolean equals = num.equals(new Integer(8));
    }
}
