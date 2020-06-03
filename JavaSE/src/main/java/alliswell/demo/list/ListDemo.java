/**
 * @Title: ListDemo
 * @Package test
 * @Description: list集合demo
 * @author alliswell
 * @date 2017/3/6 16:24
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * java.util.ConcurrentModificationException（并发修改异常）：https://www.cnblogs.com/zhuyeshen/p/10956822.html
 * *****************************************************
 */
package alliswell.demo.list;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author alliswell
 * @Title: ListDemo
 * @Package test
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017/3/6 16:24
 */
public class ListDemo implements Cloneable {

    List<Student> students;

    public static void main(String[] args) throws CloneNotSupportedException {
        Timestamp t = new Timestamp(System.currentTimeMillis());
        System.out.println(t);

        List<Student> list = new ArrayList<>();
        Student s1 = new Student("张三", "11");
        Student s2 = new Student("李四", "12");
        Student s3 = new Student("王五", "13");
        list.add(s1);
        list.add(s2);
        list.add(s3);

        modifyTest(list);
        cloneTest(list);

//        fun();
        fun2();

    }

    /**
     * Iterator不能添加和删除元素，否则会抛出异常java.util.ConcurrentModificationException（并发修改异常）
     * 源码分析：ArrayList.remove()比Itr.remove()少了一步操作expectedModCount = modCount;
     */
    public static void fun() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("2");
        list.add("1");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            // 删除第一个元素，不会抛出并发修改异常
            if ("2".equals(item)) {
                list.remove(item);
            }
        }
        System.out.println(list);

//        for (String item : list) {
//            if ("2".equals(item)) {
//                list.remove(item);
//            }
//        }

        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("1");
        list2.add("2");
        Iterator<String> iterator2 = list2.iterator();
        while (iterator2.hasNext()) {
            String item = iterator2.next();
            // 删除最后一个元素，才会抛出并发修改异常
            if ("2".equals(item)) {
                list2.remove(item);
            }
        }
        System.out.println(list2);
    }

    /**
     * 多线程时ConcurrentModificationException异常解决办法：
     * 1）在使用iterator迭代的时候使用synchronized或者Lock进行同步；
     * 2）使用并发容器CopyOnWriteArrayList代替ArrayList和Vector。
     */
    public static void fun2() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                Iterator<Integer> iterator = list.iterator();
                while (iterator.hasNext()) {
                    Integer integer = iterator.next();
//                    System.out.println(integer);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            ;
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                Iterator<Integer> iterator = list.iterator();
                while (iterator.hasNext()) {
                    Integer integer = iterator.next();
                    if (integer == 2) {
                        iterator.remove();
                    }
                }
            }

            ;
        };
        thread1.start();
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(list);
    }

    /**
     * foreach、Iterator、fori三种方式遍历集合时修改集合,foreach会异常ConcurrentModificationException
     * @param list
     */
    public static void modifyTest(List<Student> list) {
//        for (Student o : list) {
//            if ("张三".equals(o.getName())) {
//                list.remove(o);
//            }
//            System.out.println(o.getName() +":"+ o.getAge());
//            System.out.println(list.size());
//        }

//        for (int i=0; i<list.size(); i++) {
//            Student o = list.get(i);
//            if ("王五".equals(o.getName())) {
//                list.remove(o);
//            }
//            System.out.println(o.getName() +":"+ o.getAge());
//            System.out.println(list.size());
//        }

//        Iterator it = list.iterator();
//        while (it.hasNext()) {
//            Student o = (Student) it.next();
//            if ("王五".equals(o.getName())) {
////                list.remove(o);
//                it.remove();
//            }
//            System.out.println(o.getName() +":"+ o.getAge());
//            System.out.println(list.size());
//        }
    }


    /**
     * 对象的clone，存在深浅
     * 被克隆的对象需要实现Cloneable接口，并重写clone方法
     * @param list
     */
    public static void cloneTest(List<Student> list) {
        ListDemo ld = new ListDemo();
        ld.setStudents(list);

        ListDemo ld2 = (ListDemo) ld.clone();
        ld2.getStudents().get(0).setAge("15");
        isDeepClone(ld, ld2);

        ListDemo ld3 = ld;
        ld3.getStudents().get(0).setAge("20");
        isDeepClone(ld, ld3);
    }

    public static void isDeepClone(ListDemo ld, ListDemo ld3) {
        if (ld != ld3 && ld.getStudents().get(0) != ld3.getStudents().get(0)) {
            System.out.println("深克隆");
        } else {
            System.out.println("浅克隆");
        }

        // 深度克隆时两值相互独立，浅克隆只是复制了对象的引用，而引用对应的值是同一个
        // 被克隆对象
        System.out.println(ld.getStudents().get(0).getAge());
        // 克隆对象
        System.out.println(ld3.getStudents().get(0).getAge());
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public Object clone() {
        ListDemo o = null;
        try {
            o = (ListDemo) super.clone();
            o.students = new ArrayList<>();
            for (int i = 0; i < students.size(); i++) {
                o.students.add((Student) students.get(i).clone());
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }
}

class Student implements Cloneable {
    String name;
    String age;

    public Student(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public Object clone() {
        Student o = null;
        try {
            o = (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }
}
