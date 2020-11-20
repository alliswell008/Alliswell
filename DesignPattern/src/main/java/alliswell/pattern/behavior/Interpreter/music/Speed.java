package alliswell.pattern.behavior.Interpreter.music;

/**
 * 音速
 *
 * @author chengxs
 * @date 2020/11/19
 */
public class Speed extends Expression {
    @Override
    protected void excute(String key, double value) {
        String speed = "";
        if (value < 500) {
            speed = "快速";
        } else if (value >= 1000) {
            speed = "慢速";
        } else {
            speed = "中速";
        }
        System.out.print(String.format("%s ", speed));
    }
}
