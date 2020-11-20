package alliswell.pattern.behavior.template.testpaper;

/**
 * 试卷
 *
 * @author chengxs
 * @date 2020/11/10
 */
public abstract class TestPaper {

    public void testQuestion1() {
        System.out.println("问题1...");
        System.out.println("答案：" + answer1());
    }

    public void testQuestion2() {
        System.out.println("问题2...");
        System.out.println("答案：" + answer2());
    }

    public void testQuestion3() {
        System.out.println("问题3...");
        System.out.println("答案：" + answer3());
    }

    protected abstract String answer1();
    protected abstract String answer2();
    protected abstract String answer3();
}
