package org.alliswell.demo.hashmapdemo;

import java.util.*;

/**
 * 已知一个 HashMap<Integer， User>集合， User 有 name（String）和 age（int）属性。请写一个方法实现对
 * HashMap 的排序功能，该方法接收 HashMap<Integer， User>为形参，返回类型为 HashMap<Integer， User>，
 * 要求对 HashMap 中的 User 的 age 倒序进行排序。排序时 key=value 键值对不得拆散。
 * Created by Administrator on 2018/3/2.
 */
public class HashMapTest {

    public static void main(String[] args) {

        HashMap<Integer, User> map = new HashMap<Integer, User>();
        map.put(1, new User("张三", 22));
        map.put(2, new User("李四", 25));
        map.put(3, new User("王五", 24));

        HashMap<Integer, User> sortMap = sortHashMap(map);
        System.out.println(sortMap);
    }

    public static HashMap<Integer, User> sortHashMap(HashMap<Integer, User> map) {
        LinkedHashMap<Integer, User> linkedHashMap = new LinkedHashMap<Integer, User>(map.size());

        Set<Map.Entry<Integer, User>> set = map.entrySet();
        List<Map.Entry<Integer, User>> list = new ArrayList<Map.Entry<Integer, User>>(set);

        Collections.sort(list, new Comparator<Map.Entry<Integer, User>>() {
            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                return o2.getValue().getAge() - o1.getValue().getAge();
            }
        });

        for (Map.Entry<Integer, User> entry : list) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }

        return linkedHashMap;
    }
}

class User {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}