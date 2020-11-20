package alliswell.pattern.behavior.state.workstate;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/10
 */
public class EveningState extends WorkState {
    @Override
    public void writeProgram(Work work) {
        // 增加需求：超过20点，强制下班
        if (work.getHour() >= 20) {
            System.out.println(String.format("当前时间：%s点，超过20点，强制下班", work.getHour()));
            work.setCurrent(new RestState());
            work.writeProgram();
        }

        if (work.getFinish()) {
            work.setCurrent(new RestState());
            work.writeProgram();
        } else {
            if (work.getHour() < 21) {
                System.out.println(String.format("当前时间：%s点，加班哦，疲累至极", work.getHour()));
            } else {
                work.setCurrent(new SleepingState());
                work.writeProgram();
            }
        }
    }
}
