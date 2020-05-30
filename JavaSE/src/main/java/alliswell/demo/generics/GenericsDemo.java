package alliswell.demo.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 泛型的本质是参数化类型，也就是说所操作的数据类型被指定为一个参数。
 *
 * @author chengxs
 * @date 2019/7/7
 */
public class GenericsDemo {
    static List<? super GenericsAB> list33 = new ArrayList<>();

    public static void main(String[] args) {

        // 通配符其实在声明变量（局部变量、全局变量、常量）时是没有什么意义的
        List<? super GenericsAB> list11 = new ArrayList<>();
//        list11.add(new GenericsA());
//        list11.add(new GenericsAB());
//        list11.add(new GenericsAC());
//        list11.add(new Object());

        List<? extends GenericsA> list22 = new ArrayList<>();
//        list22.add(new GenericsA());
//        list22.add(new GenericsAB());
//        list22.add(new GenericsAC());
//        list22.add(new Object());

//        list33.add(new GenericsA());
//        list33.add(new GenericsAB());
//        list33.add(new GenericsAC());
//        list33.add(new Object());


        List<GenericsA> list = new ArrayList<>();
        addFun(list, new GenericsA());
        addFun(list, new GenericsAB());
        addFun(list, new GenericsAC());
        // 编译时自动检查
//        addFun(list, new GenericsC());
        System.out.println(list);

        int count = addFun(list);
        System.out.println(count);

        List<GenericsA> list2 = new ArrayList<>();
        addGenericsFun(list2, new GenericsA());
        addGenericsFun(list2, new GenericsAB());
        addGenericsFun(list2, new GenericsAC());
        // 编译时自动检查
//        addGenericsFun(list2, new GenericsC());
        System.out.println(list2);

    }

    public static List<? extends GenericsA> addFun(List<GenericsA> list, GenericsA t) {
        list.add(t);
        return list;
    }

    public static List<? super GenericsA> addGenericsFun(List<? super GenericsA> list, GenericsA t) {
        list.add(t);
        return list;
    }

    public static int addFun(List<? extends GenericsA> list) {
        int count = 0;
        for (GenericsA a : list) {
            count ++;
        }
        return count;
    }

    public static int addFun2(List<? super GenericsAB> list) {
        list.add(new GenericsAB());
        int count = 0;
        for (Object a : list) {
            if (a instanceof GenericsA) {
                count ++;
            }
        }
        return count;
    }

}
