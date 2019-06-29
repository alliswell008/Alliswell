package alliswell.demo.method;

import java.util.HashMap;
import java.util.Map;

/**
 * 方法参数是值传递还是引用传递
 * 值传递：方法内的赋值不会传递给参数
 * 引用传递：方法内的赋值会传递给参数
 */
public class MethodParameterDemo {

    public static void main(String[] args) {

        // 基本数据类型：值传递
        int i = 0;
        setInt(i);//方法内赋值为10
        System.out.println(i);//输出：0

        // String类型：值传递
        String s = "string";
        setStr(s);//方法内赋值为new string
        System.out.println(s);//输出：string

        // 除String以外的引用类型，以Map为例：引用传递
        Map map = new HashMap();
        setMap(map);//方法内赋值为{new key=new value}
        System.out.println(map);//输出：{new key=new value}

        // 除String以外的引用类型，以自定义User为例：引用传递
        User u = new User();
        u.setName("name");
        setUser(u);//方法内赋值为name
        System.out.println(u.getName());//输出：new name
    }

    public static void setInt(int i) {
        i = 10;
    }

    public static void setStr(String s) {
        s = "new string";
    }

    public static void setMap(Map map) {
        map.put("new key", "new value");
    }

    public static void setUser(User user) {
        user.setName("new name");
    }

    static class User {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
