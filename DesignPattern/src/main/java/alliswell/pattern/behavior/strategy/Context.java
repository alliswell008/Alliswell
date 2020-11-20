package alliswell.pattern.behavior.strategy;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/17
 */
public class Context {
    private ICalculator calculator;

    public Context(ICalculator calculator) {
        this.calculator = calculator;
    }

    public void calculate(String exp) {
        int calculate = calculator.calculate(exp);
        System.out.println(calculate);
    }
}
