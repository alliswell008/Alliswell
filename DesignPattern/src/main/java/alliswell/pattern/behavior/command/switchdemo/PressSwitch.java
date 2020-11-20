package alliswell.pattern.behavior.command.switchdemo;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/4
 */
public class PressSwitch {

    public static void main(String[] args){
        Light lamp = new Light();
        Command switchUp = new FlipUpCommand(lamp);
        Command switchDown = new FlipDownCommand(lamp);

        Switch mySwitch = new Switch();

        args = new String[] {"ON"};

        switch(args[0]) {
            case "ON":
                mySwitch.storeAndExecute(switchUp);
                break;
            case "OFF":
                mySwitch.storeAndExecute(switchDown);
                break;
            default:
                System.out.println("Argument \"ON\" or \"OFF\" is required.");
        }
    }

}
