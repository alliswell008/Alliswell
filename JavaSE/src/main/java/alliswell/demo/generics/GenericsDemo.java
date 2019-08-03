package alliswell.demo.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2019/7/7
 */
public class GenericsDemo {


    public static void main(String[] args) {

        //
        List<GenericsA> list = new ArrayList<>();
        addFun(list, new GenericsA());
        addFun(list, new GenericsAB());
        addFun(list, new GenericsAC());
//        addFun(list, new GenericsC());
        System.out.println(list);


        List<GenericsA> list2 = new ArrayList<>();
        addGenericsFun(list2, new GenericsA());
        addGenericsFun(list2, new GenericsAB());
        addGenericsFun(list2, new GenericsAC());
//        addGenericsFun(list2, new GenericsC());
        System.out.println(list2);

        fun();
    }

    public static List<GenericsA> addFun(List list, GenericsA t) {
        list.add(t);
        return list;
    }

    public static List<? extends GenericsA> addGenericsFun(List list, GenericsA t) {
        list.add(t);
        return list;
    }


    public static void fun() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            String item = iterator.next();
//            if ("1".equals(item)) {
//                iterator.remove();
//            }
//        }

        for (String item : list) {
            if ("2".equals(item)) {
                list.remove(item);
            }
        }
    }
}
