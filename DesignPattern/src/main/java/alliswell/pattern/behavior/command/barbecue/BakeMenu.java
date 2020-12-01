package alliswell.pattern.behavior.command.barbecue;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/11/4
 */
public enum BakeMenu {
    /**
     * 面筋
     */
    Gluten("面筋"),
    /**
     * 羊肉
     */
    Mutton("羊肉");

    private String value;

    BakeMenu(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
