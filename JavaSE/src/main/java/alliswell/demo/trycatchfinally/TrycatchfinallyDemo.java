package alliswell.demo.trycatchfinally;

/**
 * @Title: TrycatchfinallyDemo
 * @Package alliswell.demo.trycatchfinally
 * @Description: Try-catch-finally语句demo
 * @Author Administrator
 * @CreateDate 2019/5/20 15:35
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
public class TrycatchfinallyDemo {

    public static void main(String[] args) {
        String str = testFinally();
        System.out.println(str);
    }

    public static String testFinally() {
        try {
            return "string";
        } catch (Exception e) {

        } finally {
            // 不论是否抛出异常或者直接return，都会执行
            System.out.println("finally语句");
            // 被最终采纳，所以返回的是null而不是“string”
            return null;
        }
    }
}
