package test;

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

        // 抛出异常NPE
        boolean equals = num.equals(new Integer(8));
    }
}
