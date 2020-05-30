package alliswell.demo.list;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/5/18
 */
public class SubList {

    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add(1);
        List list1 = list.subList(0, 1);
        list.add(2);
        System.out.println(list);

        /**
         * 在subList场景中，高度注意对父集合元素的增加或删除，
         * 均会导致子列表的遍历、增加、删除产生ConcurrentModificationException 异常。
         */
        System.out.println(list1);
    }
}
