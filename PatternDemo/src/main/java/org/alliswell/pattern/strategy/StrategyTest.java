package src.main.java.org.alliswell.pattern.strategy;

public class StrategyTest {

    public static void main(String[] args) {
        String exp = "12+8";
        ICalculator cal = new Plus();
        int result = cal.calculate(exp);
        System.out.println(result);
    }
}
