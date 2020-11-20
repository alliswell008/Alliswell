package alliswell.pattern.behavior.template.testpaper;

/**
 * 学生A的答案
 *
 * @author chengxs
 * @date 2020/11/10
 */
public class TestPaperA extends TestPaper{

    @Override
    protected String answer1() {
        return "a";
    }

    @Override
    protected String answer2() {
        return "b";
    }

    @Override
    protected String answer3() {
        return "c";
    }
}
