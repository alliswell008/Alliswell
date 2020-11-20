package alliswell.pattern.behavior.command.paint;

import java.awt.*;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/3
 */
public class DrawCommand implements Command {

    private Drawable drawable;
    private Point position;

    public DrawCommand(Drawable drawable, Point position) {
        this.drawable = drawable;
        this.position = position;
    }

    @Override
    public void execute() {
        drawable.draw(position.x, position.y);
    }
}
