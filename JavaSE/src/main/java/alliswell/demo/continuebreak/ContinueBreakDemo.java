/**
 * @Title: ContinueBreakDemo.java
 * @Package com.alliswell008.testcontinue
 * @Description: continue和break的使用
 * @author org.alliswell
 * @date 2016-11-20 下午2:20:01
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package alliswell.demo.continuebreak;

/**
 * @ClassName: ContinueBreakDemo
 * @Description: continue跳过当前值继续魂环，break从当前值开始中断跳出循环
 * @author org.alliswell
 * @date 2016-11-20 下午2:20:01
 *
 */
public class ContinueBreakDemo {
    public static void main(String[] args) {
        continue_Fun();
        System.out.println("-----");
        break_Fun();
        System.out.println("-----");
        label_Fun();
    }

    public static void continue_Fun() {
        int i = 0;
        System.out.println("i=" + i);
        while (i < 10) {
            i++;
            if (i % 3 == 0) {
                continue;//0,1,2,4,5,7,8,10
            }
            System.out.println("i=" + i);
        }
    }

    public static void break_Fun() {
        int i = 0;
        System.out.println("i=" + i);
        while (i < 10) {
            i++;
            if (i % 3 == 0) {
                break;//0,1,2
            }
            System.out.println("i=" + i);
        }
    }

    public static void label_Fun() {
        bk: // label
        for (int i = 0; i < 10; i++) {
            System.out.println("i=" + i);
            for (int j = 0; j < 10; j++) {
                System.out.println("j=" + j);
                if (j == 2) {
                    System.out.println("bk");
                    break bk;
                }
            }
        }
        System.out.println("bk over");
    }
}
