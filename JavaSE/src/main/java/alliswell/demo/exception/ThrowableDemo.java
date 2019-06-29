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
    }
}
