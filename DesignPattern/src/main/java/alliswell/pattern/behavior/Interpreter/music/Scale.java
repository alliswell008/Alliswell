package alliswell.pattern.behavior.Interpreter.music;

/**
 * 音阶
 *
 * @author chengxs
 * @date 2020/11/18
 */
public class Scale extends Expression {

    @Override
    protected void excute(String key, double value) {
        String scale = "";
        int c = 0;
        if ("O".equals(key)) {
            c = (int) value;
        }
        switch (c) {
            case 1:
                scale = "低音";
                break;
            case 2:
                scale = "中音";
                break;
            case 3:
                scale = "高音";
                break;
        }
        System.out.print(String.format("%s ", scale));
    }
}
