package alliswell.pattern.behavior.state.workstate;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/10
 */
public class RestState extends WorkState {
    @Override
    public void writeProgram(Work work) {
            System.out.println(String.format("当前时间：%s点，下班回家了", work.getHour()));
    }
}
