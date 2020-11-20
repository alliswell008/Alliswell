package alliswell.pattern.behavior.state.workstate;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/10
 */
public class AfternoonState extends WorkState {
    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 17) {
            System.out.println(String.format("当前时间：%s点，下午状态还不错，继续努力", work.getHour()));
        } else {
            work.setCurrent(new EveningState());
            work.writeProgram();
        }
    }
}
