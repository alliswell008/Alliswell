package alliswell.pattern.behavior.Interpreter;

/**
 * 具体表达式
 *
 * @author chengxs
 * @date 2020/11/18
 */
public class NonterminalExpression extends AbstractExpression {
    @Override
    public void interpret(Context context) {
        System.out.println("非终端解释器");
    }
}
