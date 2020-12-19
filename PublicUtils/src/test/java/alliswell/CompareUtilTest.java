package alliswell;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompareUtilTest {

    @Test
    void compare() throws Exception {
        User u1 = new User("张三", 20);
        User u2 = new User("张三", 21);
        CompareUtil.compare(u1, u2);
    }
}

class User {

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }
}