package alliswell.pattern.behavior.strategy;

public class StrategyTest {

    public static void main(String[] args) {
        String exp = "12+8";
        ICalculator cal = new Plus();
        int result = cal.calculate(exp);
        System.out.println(result);

        Context context = new Context(new Plus());
        context.calculate(exp);
    }
}
