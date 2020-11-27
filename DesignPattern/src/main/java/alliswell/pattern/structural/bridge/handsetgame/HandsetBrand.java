package alliswell.pattern.structural.bridge.handsetgame;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/23
 */
public abstract class HandsetBrand {

    protected HandsetSoft soft;

    /**
     * 设置手机软件
     *
     * @param soft
     */
    public void setHandsetSoft(HandsetSoft soft) {
        this.soft = soft;
    }

    public abstract void run();
}
