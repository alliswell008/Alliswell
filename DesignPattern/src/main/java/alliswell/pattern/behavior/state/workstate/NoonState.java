package alliswell.pattern.behavior.state.workstate;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/10
 */
public class NoonState extends WorkState {
    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 13) {
            System.out.println(String.format("当前时间：%s点，饿了，午饭后犯困午休", work.getHour()));
        } else {
            work.setCurrent(new AfternoonState());
            work.writeProgram();
        }
    }
}
