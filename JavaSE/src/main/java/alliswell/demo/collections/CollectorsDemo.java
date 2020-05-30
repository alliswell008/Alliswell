package alliswell.demo.collections;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/5/18
 */
public class CollectorsDemo {

    public static void main(String[] args) {
        List<Pair<String, Double>> pairArrayList = new ArrayList<>(3);
        pairArrayList.add(new Pair<>("version", 6.19));
        pairArrayList.add(new Pair<>("version", 10.24));
        pairArrayList.add(new Pair<>("version", 13.14));
        Map<String, Double> map = pairArrayList.stream().collect(
                // 生成的map集合中只有一个键值对：{version=13.14}
                Collectors.toMap(Pair::getKey, Pair::getValue, (v1, v2) -> v2));

        System.out.println(map);


        String[] departments = new String[] {"iERP", "iERP", "EIBU"};
        // 抛出IllegalStateException异常
        Map<Integer, String> map2 = Arrays.stream(departments)
                .collect(Collectors.toMap(String::hashCode, str -> str));

        System.out.println(map2);

        // emptyList()和singletonList()得到的list不能对其添加和删除元素，因为返回的集合是被final修饰的
        List<Object> objects = Collections.emptyList();
        objects = Collections.singletonList(pairArrayList);
    }


}
