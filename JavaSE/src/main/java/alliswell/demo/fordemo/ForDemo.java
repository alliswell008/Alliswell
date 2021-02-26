package alliswell.demo.fordemo;

import java.text.SimpleDateFormat;

/**
 * @Title: ForDemo
 * @Package alliswell.demo.fordemo
 * @Description: TODO(用一句话来说明)
 * @Author Administrator
 * @CreateDate 2019/5/20 17:42
 * @Version V1.0
 * <p>
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
public class ForDemo {

    static boolean foo(char c) {
        System.out.print(c);
        return true;
    }

    public static void main(String[] args) {

        // for循环的执行过程
        testFor();
        System.out.println();

        // 设置标签，直接跳出多重循环
        testBreakDoubleFor();
        // return; 也可以直接跳出多重循环
        testReturnDoubleFor();
    }

    private static void testFor() {
        int i = 0;
        for (foo('A'); foo('B') && (i < 2); foo('c')) {
            i++;
            foo('D');
        }
    }

    /**
     * {@link SimpleDateFormat#subParse} break parsing;
     */
    public static void testBreakDoubleFor() {
        // 设置标签，在循环中可以直接break到这个标签
//        breakloop:
        for (int i = 0; i < 10; i++) {
            System.out.println("i=" + i);
            breakloop:
            for (int j = 0; j < 10; j++) {
                if (j == 1) {
                    break breakloop;
                }
                System.out.println("j=" + j);
            }
        }
    }

    public static void testReturnDoubleFor() {
        // 设置标签，在循环中可以直接break到这个for标签
        for (int i = 0; i < 10; i++) {
            System.out.println("i=" + i);
            for (int j = 0; j < 10; j++) {
                System.out.println("j=" + j);
                if (j == 1) {
                    return;
                }
            }
        }
    }
}
