package alliswell.pattern.behavior.command.barbecue;

import java.util.HashMap;
import java.util.Map;

/**
 * 烤串师傅
 *
 * @author chengxs
 * @date 2020/11/4
 */
public class Barbecuer {

    private Map<String, BakeFood> orderStatus = new HashMap<>();

    public void bake(String orderNo, BakeFood food) {
        switch (food.food) {
            case Gluten:
                bakeGluten(orderNo, food);
                break;
            case Mutton:
                bakeMutton(orderNo, food);
                break;
            default:

        }
    }

    public void bakeCancel(String orderNo, BakeMenu bakeMenu, int num) {
        System.out.println(orderNo + "：取消了"+Math.abs(num)+"个"+bakeMenu.getValue()+"串T_T");
    }

    public void bakeGluten(String orderNo, BakeFood food) {
        System.out.println(orderNo + "：烤"+food.num+"个"+food.food.getValue()+"串！");
    }

    public void bakeMutton(String orderNo, BakeFood food) {
        System.out.println(orderNo + "：烤"+food.num+"个"+food.food.getValue()+"串！");
        // 指定0001的烤串状态为已烤
        if ("0001".equals(orderNo)) {
            food.status = true;
        }
    }
}
