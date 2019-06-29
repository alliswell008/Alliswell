package alliswell.demo.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Title: ReflectTest
 * @Package alliswell.demo.reflect
 * @Description: TODO(用一句话来说明)
 * @Author Administrator
 * @CreateDate 2019/5/25 14:08
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
public class ReflectTest {
    public static void main(String[] args) {
        try {
            Class<ReflectDemo> c = ReflectDemo.class;
            Method main = c.getMethod("main", java.lang.String[].class);
            main.invoke(null, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
