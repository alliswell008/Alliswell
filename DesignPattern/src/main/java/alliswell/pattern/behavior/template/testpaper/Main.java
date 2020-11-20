package alliswell.pattern.behavior.template.testpaper;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/10
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("A试卷：");
        TestPaper stuA = new TestPaperA();
        stuA.testQuestion1();
        stuA.testQuestion2();
        stuA.testQuestion3();

        System.out.println("B试卷：");
        TestPaper stuB = new TestPaperB();
        stuB.testQuestion1();
        stuB.testQuestion2();
        stuB.testQuestion3();
    }
}
