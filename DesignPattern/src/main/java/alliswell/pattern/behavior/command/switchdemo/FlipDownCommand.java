package alliswell.pattern.behavior.command.switchdemo;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/4
 */
public class FlipDownCommand implements Command {
    private String name = "FlipDownCommand";
    private Light theLight;

    public FlipDownCommand(Light light) {
        this.theLight = light;
    }

    @Override    // Command
    public void execute() {
        theLight.storeCommand(this);
        theLight.turnOff();
    }
}
