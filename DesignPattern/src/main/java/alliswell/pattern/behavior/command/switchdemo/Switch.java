package alliswell.pattern.behavior.command.switchdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/4
 */
public class Switch {
    private List<Command> history = new ArrayList<Command>();

    public void storeAndExecute(Command cmd) {
        this.history.add(cmd); // optional
        cmd.execute();
    }

}
