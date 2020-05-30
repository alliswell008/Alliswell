package alliswell.demo.list;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/5/18
 */
public class ToArray {
    public static void main(String[] args) {
        List list = new ArrayList<>(2);
        list.add("11");
        list.add("22");

        // 使用toArray带参方法，数组空间大小的length
        Object[] objects = list.toArray(new String[0]);
        System.out.println(objects);

        for (Object obj : objects) {
            System.out.println(obj);
        }
    }
}
