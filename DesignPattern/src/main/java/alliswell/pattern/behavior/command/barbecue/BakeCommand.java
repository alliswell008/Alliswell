package alliswell.pattern.behavior.command.barbecue;

/**
 * 烧烤
 *
 * @author chengxs
 * @date 2020/11/4
 */
public interface BakeCommand {

    /**
     * 执行烧烤命令
     */
    void execute();

    /**
     * 执行烧烤命令取消
     */
    void executeCancel();
}
