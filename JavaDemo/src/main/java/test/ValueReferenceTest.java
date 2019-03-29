package test;

import java.util.*;

/**
 * 方法参数是值传递还是引用传递
 */
public class ValueReferenceTest {

    public static void main(String[] args) {

        // 基本数据类型：值传递
        int i = 0;
        setInt(i);
        System.out.println(i);

        // String类型：值传递
        String s = "string";
        setStr(s);
        System.out.println(s);

        // 出String以外的引用类型，以Map为例：引用传递
        Map map = new HashMap();
        setMap(map);
        System.out.println(map);
        // 出String以外的引用类型，以自定义User为例：引用传递
        User u = new User();
        u.setName("name");
        setUser(u);
        System.out.println(u.getName());

        int[] a = new int[2];
        Arrays.sort(new int[]{});
        Collections.sort(new ArrayList());

        WeakHashMap weakHashMap = new WeakHashMap();
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
