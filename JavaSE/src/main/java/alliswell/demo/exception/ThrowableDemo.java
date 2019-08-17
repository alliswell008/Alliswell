package alliswell.demo.exception;

/**
 * @Title: Throwable
 * @Package alliswell.demo.exception
 * @Description: TODO(用一句话来说明)
 * @Author Administrator
 * @CreateDate 2019/5/20 15:50
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
public class ThrowableDemo {

    public static void main(String[] args) {

        Throwable throwable = new Throwable();
        try {
            throw throwable;
        } catch (Throwable throwable1) {
            throwable1.printStackTrace();
        }

        // 异常按顺序捕获
        getCustomerInfo();
    }

    public static void getCustomerInfo() {
        try {
// do something that may cause an Exception
            throw new java.io.IOException();
        } catch (java.io.FileNotFoundException ex) {
            System.out.println("FileNotFoundException!");
        } catch (java.io.IOException ex) {
            System.out.println("IOException!");
        } catch (java.lang.Exception ex) {
            System.out.println("Exception!");
        }
    }
}
