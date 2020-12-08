package alliswell.demo.reflect;

import java.util.List;
import java.util.Map;

/**
 * @Title: ReflectDemo
 * @Package alliswell.demo.reflect
 * @Description: TODO(用一句话来说明)
 * @Author Administrator
 * @CreateDate 2019/5/25 13:57
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
public class ReflectDemo {

    private String name;

    private int age;

    private Map<String, ReflectDemo> map;

    private ReflectDemo() {
    }

    public ReflectDemo(String name) {
        this.name = name;
    }

    public ReflectDemo(int age) {
        this.age = age;
    }

    public ReflectDemo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Map<String, ReflectDemo> getMap() {
        return map;
    }

    public void setMap(Map<String, ReflectDemo> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "ReflectDemo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        System.out.println("main方法运行了");
    }
}
