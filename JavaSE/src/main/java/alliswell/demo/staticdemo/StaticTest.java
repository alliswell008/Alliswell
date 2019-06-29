package alliswell.demo.staticdemo;

/**
 * @Title: StaticTest
 * @Package alliswell.demo.staticdemo
 * @Description: TODO(用一句话来说明)
 * @Author Administrator
 * @CreateDate 2019/5/20 18:17
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
public class StaticTest {
    public static void main(String[] args) {
        try {
            // 静态代码块在类加载时执行
            Class.forName("alliswell.demo.staticdemo.StaticInnerClassDemo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
