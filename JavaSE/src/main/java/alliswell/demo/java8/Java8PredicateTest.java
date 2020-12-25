package alliswell.demo.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/12/21
 */
public class Java8PredicateTest {
    public static void main(String[] args) {
        f1();
        f2();
        f3();
        f4();
        f5();
        f6();
        f7();
        f8();
    }

    /**
     * 找出大于3
     */
    public static void f1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Predicate<Integer> predicate1 = x -> x > 3;

        List<Integer> collect = list.stream().filter(predicate1).collect(Collectors.toList());

        System.out.println(collect);
    }

    /**
     * 找出大于3且小于9
     */
    public static void f2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // 等价于x -> x > 3 & x < 8
        Predicate<Integer> predicate1 = x -> x > 3;
        Predicate<Integer> predicate2 = x -> x < 9;
        List<Integer> collect = list.stream().filter(predicate1.and(predicate2)).collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * 找出长度大于3，或者以“+”结尾的所有集合
     */
    public static void f3() {
        List<String> list = Arrays.asList("java","c++","c","c#","php","kotlin","javascript");

        Predicate<String> predicate1 = x -> x.length() > 3;
        Predicate<String> predicate2 = x -> x.endsWith("+");

        List<String> collect = list.stream().filter(predicate1.or(predicate2)).collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * 找出集合中不以“+”结尾的所有集合
     */
    public static void f4() {
        List<String> list = Arrays.asList("java","c++","c","c#","php","kotlin","javascript");

        Predicate<String> predicate2 = x -> x.endsWith("+");

        List<String> collect = list.stream().filter(predicate2.negate()).collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     *  test 方法使用
     */
    public static void f5() {
        List<String> list = Arrays.asList("java", "c++", "c", "c#", "php", "kotlin", "javascript");

        Predicate<String> predicate2 = x -> x.endsWith("+");

        List<String> collect = list.stream().filter(predicate2::test).collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * 链式调用
     */
    public static void f6() {
        List<String> list = Arrays.asList("java", "c++", "c", "c#", "php", "kotlin", "javascript");

        Predicate<String> predicate2 = x -> x.startsWith("c");
        //以c开头或者以t结尾
        boolean ret = predicate2.or(x -> x.endsWith("t")).test("javascript");
        System.out.println(ret);

        //!（以c开头且长度等于4）
        boolean ret2 = predicate2.and(x -> x.length() == 4).negate().test("java");
        System.out.println(ret2);
    }

    public static void f7() {
        BiPredicate<String, Integer> filter = (x, y) -> {
            return x.length() == y;
        };

        boolean ret = filter.test("cattle", 6);
        boolean ret2 = filter.test("java", 8);
        System.out.println(ret);
        System.out.println(ret2);
    }

    /**
     * 当作参数使用
     */
    public static void f8() {
        Java8PredicateTest obj = new Java8PredicateTest();
        Student student1 = new Student("cattle", 18);
        Student student2 = new Student("tony", 22);
        Student student3 = new Student("mars", 30);
        List<Student> students = Arrays.asList(student1, student2, student3);

        BiPredicate<Integer, String> biPredicate = (age, name) -> (age >= 30 && name.equals("mars"));
        List<Student> ret = filter(students, biPredicate);
        System.out.println(ret);
    }

    public static <T extends Student> List<T> filter(List<T> stu, BiPredicate<Integer, String> biPredicate) {
        return stu.stream().filter(x -> biPredicate.test(x.getAge(), x.getName())).collect(Collectors.toList());
    }

    static class Student {
        private String name;
        private Integer age;

        public Student(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
