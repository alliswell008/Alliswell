package alliswell.pattern.behavior.command.switchdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/4
 */
public class Light {

    private List<Command> history = new ArrayList<Command>();

    public void storeCommand(Command command) {
        history.add(command);
    }

    public void turnOn() {
        System.out.println("The light is on");
        System.out.println(history);
    }

    public void turnOff() {
        System.out.println("The light is off");
        System.out.println(history);
    }

}
