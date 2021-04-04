package alliswell.app.calendar;

/**
 * 地支：子丑寅卯辰巳午未申酉戌亥
 */
public enum BrancheEnum {
    Zi(4, "子"), Chou(5, "丑"), Yin(6, "寅"), Mao(7, "卯"),
    Chen(8, "辰"), Si(9, "巳"), Wu(10, "午"), Wei(11, "未"),
    Shen(0, "申"), You(1, "酉"), Xu(2, "戌"), Hai(3, "亥");

    private final int code;
    private final String name;

    BrancheEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static BrancheEnum getEnumByYear(int year) {
        int code = year % 12;
        assert code > -1 && code < 12;

        for (BrancheEnum brancheEnum : BrancheEnum.values()) {
            if (brancheEnum.code == code) {
                return brancheEnum;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
