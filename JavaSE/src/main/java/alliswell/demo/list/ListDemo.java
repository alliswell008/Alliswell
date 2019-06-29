/**
 * @Title: ListDemo
 * @Package test
 * @Description: TODO(用一句话描述该文件做什么)
 * @author alliswell
 * @date 2017/3/6 16:24
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
 */
package alliswell.demo.list;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author alliswell
 * @Title: ListDemo
 * @Package test
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017/3/6 16:24
 */
public class ListDemo implements Cloneable  {

    List<Student> students;

    public static void main(String[] args) throws CloneNotSupportedException {
        Timestamp t = new Timestamp(new Date().getTime());
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
