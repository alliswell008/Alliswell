package alliswell.pattern.creational.builder.product;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/16
 */
public class Product {
    List<String> parts = new ArrayList<>();

    public void add(String part) {
        parts.add(part);
    }

    public void show() {
        System.out.println("产品 创建----");
        for (String part : parts) {
            System.out.println(part);
        }
    }
}
