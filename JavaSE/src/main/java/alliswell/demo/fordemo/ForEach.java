package alliswell.demo.fordemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2019/8/9
 */
public class ForEach {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(1, 2, 3);

        for (Integer integer : integerList) {
            System.out.println(integer.intValue());
        }

        integerList = new ArrayList<>();

        // integerList 不能为null否则会出现NPE
        for (Integer integer : integerList) {
            System.out.println("----");
        }
    }
}
