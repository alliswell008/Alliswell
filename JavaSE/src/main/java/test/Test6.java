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



        boolean equals = Objects.equals(num, new Integer(8));
        System.out.println(equals);
        // 抛出异常NPE
        equals = num.equals(new Integer(8));
    }
}
