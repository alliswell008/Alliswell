package alliswell.app.calendar;

/**
 * 天干：甲乙丙丁戊己庚辛壬癸
 */
public enum StemEnum {
    Jia(4, "甲"), Yi(5, "乙"), Bing(6, "丙"), Ding(7, "丁"),
    Wu(8, "戊"), Ji(9, "己"), Geng(0, "庚"), Xin(1, "辛"),
    Ren(2, "壬"), Gui(3, "癸");

    private final int code;
    private final String name;

    StemEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static StemEnum getEnumByYear(int year) {
        int code = year % 10;
        assert code > -1 && code < 10;

        for (StemEnum stemEnum : StemEnum.values()) {
            if (stemEnum.code == code) {
                return stemEnum;
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
