package alliswell.pattern.behavior.state.workstate;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/10
 */
public class ForenoonState extends WorkState {
    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 12) {
            System.out.println(String.format("当前时间：%s点，上午工作，精神百倍", work.getHour()));
        } else {
            work.setCurrent(new NoonState());
            work.writeProgram();
        }
    }
}
