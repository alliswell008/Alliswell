package alliswell.pattern.behavior.Interpreter.music;

/**
 * 表达式
 *
 * @author chengxs
 * @date 2020/11/18
 */
public abstract class Expression {
    /**
     * 解释器
     * @param context
     */
    public void interpret(PlayContext context) {
        if (context.getText().length() == 0) {
            return;
        } else {
            String playKey = context.getText().substring(0, 1);
            context.setText(context.getText().substring(2));
            double playValue = Double.parseDouble(context.getText().substring(0, context.getText().indexOf(" ")));
            context.setText(context.getText().substring(context.getText().indexOf(" ") + 1));
            excute(playKey, playValue);
        }
    }

    protected abstract void excute(String key, double value);
}
