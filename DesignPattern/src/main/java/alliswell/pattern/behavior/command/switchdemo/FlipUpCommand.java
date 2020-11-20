package alliswell.pattern.behavior.command.switchdemo;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/4
 */
public class FlipUpCommand implements Command {
    private String name = "FlipUpCommand";
    private Light theLight;

    public FlipUpCommand(Light light) {
        this.theLight = light;
    }

    @Override    // Command
    public void execute() {
        theLight.storeCommand(this);
        theLight.turnOn();
    }
}
